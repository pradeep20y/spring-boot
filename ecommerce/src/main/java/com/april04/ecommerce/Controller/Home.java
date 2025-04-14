package com.april04.ecommerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/home")
public class Home {

    @GetMapping("/")
    public String getMethodName(String param) {
        return new String("Hello World");
    }

}
