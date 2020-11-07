package com.remit.service.impl;

import com.remit.domain.UserType;
import com.remit.dto.userType.CreateUserTypeDto;
import com.remit.enums.ResponseDescription;
import com.remit.enums.ResponseObject;
import com.remit.enums.ResponseStatus;
import com.remit.repository.UserTypeRepository;
import com.remit.service.UserTypeService;
import com.remit.utils.BusinessValidationException;
import com.remit.utils.Constants;
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
        Map<Object, Object> jsonResponse = new HashMap();
       if(createUserTypeDto.getId() != null){
           UserType userType = userTypeRepository.findById(createUserTypeDto.getId()) .orElseThrow(()
                   -> new BusinessValidationException("Record not found"));
           userType.setDescription(createUserTypeDto.getDescription());
           try {
               jsonResponse.put(Constants.USER_TYPE, userTypeRepository.save(userType));
               return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
           }catch(DataIntegrityViolationException exc){
               return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
           }
       }else {

           UserType userType = new UserType();
           userType.setName(createUserTypeDto.getName());
           userType.setDescription(createUserTypeDto.getDescription());
           try {
               jsonResponse.put(Constants.USER_TYPE, userTypeRepository.save(userType));
               return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
           } catch (DataIntegrityViolationException exc) {
               return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
           }
       }
    }




}
