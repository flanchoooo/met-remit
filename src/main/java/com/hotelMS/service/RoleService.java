package com.hotelMS.service;

import com.hotelMS.domain.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    ResponseEntity save(Role role);
}
