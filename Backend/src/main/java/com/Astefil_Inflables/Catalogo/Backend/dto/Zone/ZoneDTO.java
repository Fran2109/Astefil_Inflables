package com.Astefil_Inflables.Catalogo.Backend.dto.Zone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ZoneDTO {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    private Number latitude;
    private Number longitude;

    public ZoneDTO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Number getLatitude() {
        return latitude;
    }
    public void setLatitude(Number latitude) {
        this.latitude = latitude;
    }
    public Number getLongitude() {
        return longitude;
    }
    public void setLongitude(Number longitude) {
        this.longitude = longitude;
    }
}
