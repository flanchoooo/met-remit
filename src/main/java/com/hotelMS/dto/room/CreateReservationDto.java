package com.hotelMS.dto.room;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateReservationDto implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    public String name;
    @NotNull
    public String arrivalDate;
    @NotNull
    public String departureDate;
    @NotNull

    public String RoomNumber;
    @NotNull

    public String RoomPref;
    @NotNull

    public String bookingType;
    @NotNull

    public String userReference;
    @NotNull

    public String reference;
    @NotNull

    public String rate;
    @NotNull

    public String roomType;
    @NotNull

    public Double totalPrice;
    @NotNull

    public String roomNumber;
    @NotNull

    public Double discount;
    @NotNull

    public Double vatAmount;
    @NotNull

    public Double vatpercent;
}
