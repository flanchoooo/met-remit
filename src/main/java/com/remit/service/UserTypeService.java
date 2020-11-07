package com.remit.service;

import com.remit.dto.userType.CreateUserTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserTypeService {
    ResponseEntity save(CreateUserTypeDto createUserTypeDto);
}
