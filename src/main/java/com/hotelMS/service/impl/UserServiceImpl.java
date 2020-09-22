package com.hotelMS.service.impl;

import com.hotelMS.domain.User;
import com.hotelMS.dto.user.CreateUserDto;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.repository.UserRepository;
import com.hotelMS.utils.Constants;
import com.hotelMS.service.UserService;
import io.swagger.models.Model;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	protected final Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	PasswordValidationImpl passwordValidation;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword() ,getAuthority(user));
	}

	public Set getAuthority(User user) {
		Set authorities = new HashSet<>();
		user.getAccessByAccessId().getRolesById().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	@Override
	public ResponseEntity save(CreateUserDto createUserDto) {
		User user = new User();
		Map<Object, Object> jsonResponse = new HashMap();
		if (createUserDto.getPassword() != null && createUserDto.getPassword().length() > 0){
			if (!createUserDto.getPassword().equals(createUserDto.getPasswordConfirm())){
				return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.PASSWORD_NOT_MATCH.getDescription(), jsonResponse);
			}

			String pwdValid = passwordValidation.validatePassword(createUserDto.getPassword());
			if (pwdValid != null){
				return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), pwdValid, jsonResponse);
			}
			user.setPassword(bcryptEncoder.encode(createUserDto.getPassword()));
			user.setPasswordConfirm(bcryptEncoder.encode(createUserDto.getPasswordConfirm()));
			user.setPasswordHistory(bcryptEncoder.encode(createUserDto.getPasswordConfirm()));
			user.setAccessId(createUserDto.getAccessId());
			user.setCompanyId(createUserDto.getCompanyId());
			user.setEmail(createUserDto.getEmail());
			user.setLastname(createUserDto.getLastname());
			user.setFirstname(createUserDto.getFirstname());
			user.setReferenceId(createUserDto.getReferenceId());
			user.setUsername(createUserDto.getUsername());
			user.setActive(Boolean.TRUE);
			user.setLoginTries(0);
			user.setDateOfBirth(createUserDto.getDateOfBirth());
			user.setGender(createUserDto.getGender());
			user.setNationality(createUserDto.getNationality());
			user.setPhoneNumber(createUserDto.getPhoneNumber());
			user.setReference(createUserDto.getReference());
		}

		try {
			jsonResponse.put(Constants.USER, userRepository.save(user));
			return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.USER_REGISTRATION.getDescription(), jsonResponse);
		}catch(DataIntegrityViolationException exc){
			return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage(), jsonResponse);
		}catch (ConstraintViolationException exc){
			return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getCause().getLocalizedMessage(), jsonResponse);
		}
	}
}