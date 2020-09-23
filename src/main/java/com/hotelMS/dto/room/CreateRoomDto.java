package com.hotelMS.dto.room;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateRoomDto implements Serializable {

    private static final long serialVersionUID = -267291779096992505L;

    @NotNull
    public String roomType;
    @NotNull
    public String roomReference;
    @NotNull
    public String roomNumber;
    @NotNull
    public String roomPrice;
    @NotNull
    public String category;
    @NotNull
    public String name;
    @NotNull
    public String discount;
}
