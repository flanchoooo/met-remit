package com.remit.service.impl;


import com.remit.domain.AgentEntity;
import com.remit.domain.TransfersEntity;
import com.remit.domain.UsersEntity;
import com.remit.dto.BaseResponseDTO;
import com.remit.dto.remit.TransferDto;
import com.remit.repository.AgentEntityRepository;
import com.remit.repository.TransferEntityRepository;
import com.remit.repository.UsersClassEntityRepository;
import com.remit.repository.UsersEntityRepository;
import com.remit.service.TransferService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.LockModeType;
import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {
	protected final Log logger = LogFactory.getLog(this.getClass());

	@Resource
	TransferEntityRepository transferEntityRepository;

	@Resource
	UsersClassEntityRepository usersClassEntityRepository;

	@Resource
	UsersEntityRepository usersEntityRepository;

	@Resource
	AgentEntityRepository agentEntityRepository;

	 BigDecimal limit = BigDecimal.valueOf(10000.00);

	@Override
	@Transactional(rollbackFor = Exception.class)
	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
	public BaseResponseDTO transfer(TransferDto transferDto) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		AgentEntity agentEntity = agentEntityRepository.findByAgentName(transferDto.getAgentId());
		if(agentEntity == null){
			baseResponseDTO.setCode("404");
			baseResponseDTO.setDescription("Agent not found");
			return  baseResponseDTO;
		}

		UsersEntity usersEntity = usersEntityRepository.findByMobile(transferDto.getSenderMobile());
		if(usersEntity == null){
			baseResponseDTO.setCode("404");
			baseResponseDTO.setDescription("Sender is not registered, please complete KYC.");
			return  baseResponseDTO;
		}

		if(!usersEntity.getStatus().equals("ACTIVE")){
			baseResponseDTO.setCode("401");
			baseResponseDTO.setDescription("Sender is not authorized to send money, please contact support for assistance.");
			return  baseResponseDTO;
		}

		if (transferDto.getAmount().compareTo(agentEntity.getBalance()) > 0) {
			baseResponseDTO.setCode("401");
			baseResponseDTO.setDescription("Agent does not have sufficient funds to perform send money transaction. Please top up.");
			return  baseResponseDTO;
		}

		if (transferDto.getAmount().compareTo(limit) > 0) {
			baseResponseDTO.setCode("401");
			baseResponseDTO.setDescription("Amount provided exceeds daily limit");
			return  baseResponseDTO;
		}

		agentEntity.setBalance(agentEntity.getBalance().subtract(transferDto.getAmount()));
		String transactionReference =  String.valueOf(System.currentTimeMillis());
		TransfersEntity transfersEntity = new TransfersEntity();
		transfersEntity.setAmount(transferDto.getAmount());
		transfersEntity.setTransferRef("MT" + transactionReference);
		transfersEntity.setOtp(transactionReference);
		transfersEntity.setStatus(0);
		transfersEntity.setAgent(agentEntity.getId());
		transfersEntity.setSender(usersEntity.getId());
		transfersEntity.setRecipient(1);

		agentEntityRepository.save(agentEntity);
		transferEntityRepository.save(transfersEntity);

		baseResponseDTO.setCode("00");
		baseResponseDTO.setDescription("Transfer successfully processed. REF:" + agentEntity.getId() );
		return  baseResponseDTO;

	}
}