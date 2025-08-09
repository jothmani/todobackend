package com.jothmart.todobackend.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from this origin
@RequestMapping("/api")
public class TodoController {

    @GetMapping(path="/helloworld")
    public String getMethodName() {
        return "Welcome Back Jed with Rest Controller!";
    }

    //hellow-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        System.out.println("Hani dkhalet");
        return new HelloWorldBean("Hello World Bean must be Returned!");
        // throw new RuntimeException("There is an Error from HalloWorldBean!");
    }

    /* 
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World Path Variable: "+name);
    }
    */


    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean getAllTodos(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hallo World Path variable, %s", name));
    }



    
}
