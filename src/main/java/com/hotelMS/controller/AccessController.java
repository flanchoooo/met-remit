package com.hotelMS.controller;

import com.hotelMS.domain.Access;
import com.hotelMS.service.impl.AccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "access")
public class AccessController {

    @Autowired
    AccessServiceImpl accessService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Access access) throws Exception {
        return accessService.save(access);
    }
}
