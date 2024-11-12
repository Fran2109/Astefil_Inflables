package com.Astefil_Inflables.Catalogo.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    private Number latitude;
    private Number longitude;

    public Zone(){

    }

    public Zone(String name, Number latitude, Number longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLatitude(Number latitude){
        this.latitude = latitude;
    }
    public Number getLatitude(){
        return this.latitude;
    }
    public void setLongitude(Number longitude){
        this.longitude = longitude;
    }
    public Number getLongitude(){
        return this.longitude;
    }
}
