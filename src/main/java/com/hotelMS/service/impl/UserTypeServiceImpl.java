package com.hotelMS.service.impl;

import com.hotelMS.domain.Role;
import com.hotelMS.domain.UserType;
import com.hotelMS.dto.userType.CreateUserTypeDto;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.repository.RoleRepository;
import com.hotelMS.repository.UserTypeRepository;
import com.hotelMS.service.RoleService;
import com.hotelMS.service.UserTypeService;
import com.hotelMS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public ResponseEntity save(CreateUserTypeDto createUserTypeDto) {
        UserType userType = new UserType();
        Map<Object, Object> jsonResponse = new HashMap();

        userType.setName(createUserTypeDto.getName());
        userType.setDescription(createUserTypeDto.getDescription());
        try {
            jsonResponse.put(Constants.USER_TYPE, userTypeRepository.save(userType));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }
    }


}
