package com.remit.service;

import com.remit.domain.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    ResponseEntity save(Role role);
}
