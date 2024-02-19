package com.fsd.springboottest.springboottest.controllers;

import com.fsd.springboottest.springboottest.exections.EntitynotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({EntitynotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntitynotFoundException entityNotFoundException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", entityNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
