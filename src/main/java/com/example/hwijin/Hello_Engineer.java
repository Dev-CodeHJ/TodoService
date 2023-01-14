package com.example.hwijin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_Engineer {

    @GetMapping("/")
    public String helloEngineer(){
        return "Hello Engineer";
    }
}
