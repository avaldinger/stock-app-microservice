package com.avaldinger.customer.customerservice.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {


    @RequestMapping("/hello")
    public String greetings() {


        return "Hello";


    }
}
