package com.hotelMS.dto.guest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateGuestDto  implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    public String firstName;
    @NotNull
    public String lastName;
    @NotNull
    public String address;
    @NotNull
    public String contact;
    @NotNull
    public String arrivalDate;
    @NotNull
    public String departureDate;
    @NotNull
    public int numberOfAdult;
    @NotNull
    public String ReservationType;
    @NotNull
    public String OtherInfo;
}
