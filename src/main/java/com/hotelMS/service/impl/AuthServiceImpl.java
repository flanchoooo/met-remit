package com.hotelMS.service.impl;

import com.hotelMS.domain.Role;
import com.hotelMS.domain.User;
import com.hotelMS.dto.user.UserLoginDto;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.notification.EmailServiceImpl;
import com.hotelMS.notification.MessageTypes.PasswordResetEmail;
import com.hotelMS.repository.PlatformRepository;
import com.hotelMS.repository.RoleRepository;
import com.hotelMS.repository.UserRepository;
import com.hotelMS.security.JwtTokenUtil;
import com.hotelMS.service.AuthService;
import com.hotelMS.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    PasswordResetEmail passwordResetEmail;

    @Resource
    PlatformRepository platformRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    PasswordValidationImpl passwordValidation;

    public ResponseEntity<?> authenticateUser(UserLoginDto userLoginDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getUsername(),
                        userLoginDto.getPassword()
                )
        );
        User u = userRepository.findByUsername(userLoginDto.getUsername());
        logger.debug("got here");

        // check if the user is active/inactive
        if (!u.getActive()){
            return new ResponseObject().returnResponseBody(ResponseStatus.AUTH_FAILED.getStatus(), ResponseDescription.AUTH_FAILED_ACTIVE.getDescription());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);

        // return response with token

        Map<Object, Object> jsonResponse = new HashMap();
        jsonResponse.put(Constants.TOKEN, token);
        jsonResponse.put(Constants.USER, u);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.AUTH_SUCCESS.getDescription(), jsonResponse);
    }

    public ResponseEntity<?> activateUser(User user) {
        User dbuser = userRepository.findByToken(user.getToken());
        if (dbuser  == null){
            return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), ResponseDescription.TOKEN_ENTITY_NOT_FOUND.getDescription());
        }


        if (user.getPassword() != null && user.getPassword().length() > 0){
            if (!user.getPassword().equals(user.getPasswordConfirm())){
                return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.PASSWORD_NOT_MATCH.getDescription());
            }

            String pwdValid = passwordValidation.validatePassword(user.getPassword());
            if (pwdValid != null){
                return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), pwdValid);
            }
            dbuser.setPassword(bcryptEncoder.encode(user.getPassword()));
            dbuser.setPasswordConfirm(bcryptEncoder.encode(user.getPasswordConfirm()));
            dbuser.setActive(Boolean.TRUE);
            dbuser.setToken(null);
            dbuser.setLoginTries(0);
        }
        userRepository.save(dbuser);

        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.AUTH_RESET_SUCCESS.getDescription());
    }

    public ResponseEntity<?> resetUserPassword(User user) {
        user = userRepository.findByEmail(user.getEmail());
        if (user == null){
            return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), ResponseDescription.EMAIL_ENTITY_NOT_FOUND.getDescription());
        }
        user.setToken(UUID.randomUUID().toString());
        userRepository.save(user);

        String url = platformRepository.findById(Constants.PLATFORM_ID).get().getDomain() + "/reset_token?token=" + user.getToken();
        emailService.sendEmail(user.getEmail(), passwordResetEmail.getSubject(), passwordResetEmail.getMessage(url));
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.PASSWORD_RESET.getDescription());
    }

}
