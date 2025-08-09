package com.jothmart.todobackend.controller;

public class HelloWorldBean {


    
    private String message;

    // create the constructor
    public HelloWorldBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [message=" + message + "]";
    }


    
}
