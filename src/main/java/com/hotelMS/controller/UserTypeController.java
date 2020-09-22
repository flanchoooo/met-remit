package com.hotelMS.controller;


import com.hotelMS.domain.UserType;
import com.hotelMS.dto.userType.CreateUserTypeDto;
import com.hotelMS.repository.UserTypeRepository;
import com.hotelMS.service.impl.UserTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user_type")
public class UserTypeController {

    @Autowired
    UserTypeServiceImpl userTypeService;

    @Resource
    UserTypeRepository userTypeRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<UserType> findAll(final Pageable pageable) throws EntityNotFoundException {
        return userTypeRepository.findAll(pageable);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CreateUserTypeDto userTypeDto) throws Exception {
        return userTypeService.save(userTypeDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserType findById(@PathVariable String id) throws EntityNotFoundException {
        return userTypeRepository.findById(Integer.valueOf(id)).get();
    }


}
