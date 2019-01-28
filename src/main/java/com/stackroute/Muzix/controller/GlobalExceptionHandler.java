package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;

import com.stackroute.Muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

//import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exist")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleTrackAlreadyExistException(TrackAlreadyExistsException e)
    {
        System.out.println("Track already exist");
        //log.error("Track already exist",e);
    }
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track not found")
    @ExceptionHandler(TrackIdNotFoundException.class)
    public void handleTrackNotFoundException(TrackIdNotFoundException e){

        System.out.println("Track not found");
        //log.error("Track not found",e);
    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleTrackAlreadyUdatedException(TrackNotFoundException e){
        System.out.println("Track already exist");
       // log.error("Track already exist",e);
    }
}
