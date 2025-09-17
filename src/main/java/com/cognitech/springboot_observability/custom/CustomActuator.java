package com.cognitech.springboot_observability.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomActuator
{
    @ReadOperation
    public String myCustomActuator()
    {
        return "{\"status\": \"Custom actuator endpoint\"}";
    }
}
