package com.hotelMS.dto.reservation;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateRestuarantBookingDto implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    public String bookingType;
    @NotNull
    public String bookingReference;
    @NotNull
    public String guestNumber;
    @NotNull
    public int tableId;
    @NotNull
    public String otherRequirements;
    @NotNull
    public String customerName;
    @NotNull
    public String telephoneNumber;
}
