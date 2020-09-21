package com.hotelMS.service;

import com.hotelMS.domain.Access;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccessService {
    ResponseEntity<?> save(Access access);
}
