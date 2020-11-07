package com.remit.service;

import com.remit.dto.BaseResponseDTO;
import com.remit.dto.remit.TransferDto;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    BaseResponseDTO transfer(TransferDto transferDto);
}
