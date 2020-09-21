package com.hotelMS.dto.user;

import com.hotelMS.domain.Access;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CreateUserDto implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    private Integer accessId;

    @NotNull
    private Integer companyId;

    @NotNull
    private String email;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String password;

    @NotNull
    private String passwordConfirm;

    @NotNull
    private Integer referenceId;

    @NotNull
    private String username;

    @NotNull
    private Integer loginTries;

    @NotNull
    public String dateOfBirth;

    @NotNull
    public String gender;

    @NotNull
    public String nationality;

    @NotNull
    public String phoneNumber;

    @NotNull
    public String reference;

}
