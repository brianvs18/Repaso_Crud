package com.example.Repaso_CRUD.exception;

import com.example.Repaso_CRUD.enums.CinemaErrorEnum;

public class CinemaException extends RuntimeException{

    public CinemaException(CinemaErrorEnum error){
        super(error.name());
    }
}
