package com.hotelMS.dto.reservation;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateRestuarantDto  implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    public String item;
    @NotNull
    public String itemType;
    @NotNull
    public Double price;
    @NotNull
    public Double totalAmount;
    @NotNull
    public Double quantity;
    @NotNull
    public Double discount;
    @NotNull
    public String guestName;
    @NotNull
    public String payMethod;
    @NotNull
    public String checkoutRef;
}
