package com.hotelMS.service.impl;

import com.hotelMS.domain.Role;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.repository.RoleRepository;
import com.hotelMS.service.RoleService;
import com.hotelMS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity save(Role role) {
        Map<Object, Object> jsonResponse = new HashMap();

        if (role.getId() != null){
            role = roleRepository.findById(role.getId()).get();
            if (role == null){
                return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), ResponseDescription.ENTITY_NOT_FOUND.getDescription());
            }
        }

        try {
            jsonResponse.put(Constants.PLATFORM, roleRepository.save(role));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }
    }
}
