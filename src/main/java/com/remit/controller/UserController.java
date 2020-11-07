package com.remit.controller;

import com.remit.domain.Role;
import com.remit.domain.User;
import com.remit.dto.user.CompanyDto;
import com.remit.dto.user.CreateUserDto;
import com.remit.dto.user.UserLoginDto;
import com.remit.repository.RoleRepository;
import com.remit.service.impl.AuthServiceImpl;
import com.remit.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController



public class UserController {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private AuthServiceImpl authService;

    @Resource
    RoleRepository roleRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        return userDetailsService.save(createUserDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto) throws Exception {
        return authService.authenticateUser(userLoginDto);
    }

    @RequestMapping(value = "/password_reset", method = RequestMethod.POST)
    public ResponseEntity<?> resetUserPassword(@RequestBody User user) throws Exception {
        return authService.resetUserPassword(user);
    }

    @RequestMapping(value = "/activate_account", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('USER_ACTIVATION')")
    public ResponseEntity<?> validate(@RequestBody User user) throws Exception {
        return authService.activateUser(user);
    }

    @RequestMapping(value="/getUserDetails", method = RequestMethod.POST)
    public Object getDetails(@RequestBody CompanyDto companyDto) throws Exception {
        return userDetailsService.getAllUser(companyDto);
    }

    @RequestMapping(value = "get_roles/{id}", method = RequestMethod.GET)
    public Role getProfile(@PathVariable Integer id) {
        return roleRepository.findAllByAccessId(id);
    }

}