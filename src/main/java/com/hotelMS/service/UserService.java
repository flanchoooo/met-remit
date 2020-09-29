package com.hotelMS.service;

import com.hotelMS.domain.Role;
import com.hotelMS.domain.User;
import com.hotelMS.dto.user.CreateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    ResponseEntity save(CreateUserDto createUserDto);
}
