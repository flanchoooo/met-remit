package com.hotelMS.service.impl;

import com.hotelMS.domain.Platform;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.repository.PlatformRepository;
import com.hotelMS.service.PlatformService;
import com.hotelMS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    PlatformRepository platformRepository;

    @Override
    public ResponseEntity<?> save(Platform platform) {
        Map<Object, Object> jsonResponse = new HashMap();

        if (platform.getId() != null){
            platform = platformRepository.findById(platform.getId()).get();
            if (platform == null){
                return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), ResponseDescription.ENTITY_NOT_FOUND.getDescription());
            }
        }

        try {
            jsonResponse.put(Constants.PLATFORM, platformRepository.save(platform));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }

    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Map<Object, Object> jsonResponse = new HashMap();
        try {
            jsonResponse.put(Constants.PLATFORM, platformRepository.save(platformRepository.findById(id).get()));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch (NoSuchElementException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), exc.getCause().getLocalizedMessage());
        }
    }

}
