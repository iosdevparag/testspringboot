package com.fsd.springboottest.springboottest.exections;

public class EntitynotFoundException extends RuntimeException{
    public EntitynotFoundException(String message){
        super(message);
    }
}
