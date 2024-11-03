package com.Astefil_Inflables.Catalogo.Backend.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}