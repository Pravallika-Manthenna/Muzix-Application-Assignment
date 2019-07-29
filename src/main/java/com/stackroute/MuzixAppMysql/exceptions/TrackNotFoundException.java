package com.stackroute.MuzixAppMysql.exceptions;

//track not found exception extending exception 
public class TrackNotFoundException extends Exception {

    //declaring string variabale
    private String message;

    //default constructor
    public TrackNotFoundException(){}

    //constructor with string message parameter
    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
