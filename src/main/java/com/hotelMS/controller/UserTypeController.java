package com.hotelMS.controller;

import com.hotelMS.domain.Role;
import com.hotelMS.dto.userType.CreateUserTypeDto;
import com.hotelMS.service.impl.RoleServiceImpl;
import com.hotelMS.service.impl.UserTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/user_type")
public class UserTypeController {

    @Autowired
    UserTypeServiceImpl userTypeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CreateUserTypeDto userTypeDto) throws Exception {
        return userTypeService.save(userTypeDto);
    }

}
