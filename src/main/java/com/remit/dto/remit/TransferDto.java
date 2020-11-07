package com.remit.dto.remit;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {

    private static final long serialVersionUID = -267291779096992505L;

    private String AgentId;

    private BigDecimal amount;

    private String senderMobile;

    private String sendIdentification;

    private String recipientMobile;

    private String recipientIdentification;

    private String narration;

}
