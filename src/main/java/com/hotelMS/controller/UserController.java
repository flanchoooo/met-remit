package com.hotelMS.controller;

import com.hotelMS.domain.User;
import com.hotelMS.dto.user.CompanyDto;
import com.hotelMS.dto.user.CreateUserDto;
import com.hotelMS.dto.user.UserLoginDto;
import com.hotelMS.service.impl.AuthServiceImpl;
import com.hotelMS.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private AuthServiceImpl authService;

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
}