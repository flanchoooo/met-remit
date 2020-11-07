package com.remit.controller;

import com.remit.domain.Role;
import com.remit.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Role access) throws Exception {
        return roleService.save(access);
    }

}
