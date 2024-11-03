package com.Astefil_Inflables.Catalogo.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;


@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Order Number cannot be null")
    @Min(value = 1, message = "Order Number must be greater than 0")
    private Integer orderNumber;

    public Category(){

    }

    public Category(String name, Integer orderNumber){
        this.name = name;
        this.orderNumber = orderNumber;
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
    public void setOrderNumber(Integer orderNumber){
        this.orderNumber = orderNumber;
    }
    public Integer getOrderNumber(){
        return this.orderNumber;
    }
}
