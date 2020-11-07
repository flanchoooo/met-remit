package com.remit.service;

import com.remit.domain.Platform;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlatformService {
    ResponseEntity<?> save(Platform platform);

    ResponseEntity<?> findById(int id);
}
