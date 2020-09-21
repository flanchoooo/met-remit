package com.hotelMS.service;

import com.hotelMS.domain.Platform;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlatformService {
    ResponseEntity<?> save(Platform platform);

    ResponseEntity<?> findById(int id);
}
