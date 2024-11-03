package com.Astefil_Inflables.Catalogo.Backend.exceptions;

public class NotAllowedException extends RuntimeException{
    public NotAllowedException(String message){
        super(message);
    }
}