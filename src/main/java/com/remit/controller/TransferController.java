package com.remit.controller;

import com.remit.dto.BaseResponseDTO;
import com.remit.dto.remit.TransferDto;
import com.remit.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class TransferController {

    @Autowired
    TransferServiceImpl transferService;


    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public BaseResponseDTO transfer(@RequestBody TransferDto transferDto) throws Exception {
        return transferService.transfer(transferDto);
    }
}
