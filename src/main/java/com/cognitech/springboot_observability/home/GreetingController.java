package com.cognitech.springboot_observability.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController
{
    @GetMapping
    public String helloWorld()
    {
        return "Hello Spring Observability";
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping("/{user}")
    public String helloGreeting(@PathVariable String user)
    {
        return "Hello " + user;
    }
}
