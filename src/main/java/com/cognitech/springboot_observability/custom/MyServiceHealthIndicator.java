package com.cognitech.springboot_observability.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyServiceHealthIndicator implements HealthIndicator
{
    //--- Name of class (before HealthIndicator is used to show in /health, see below:
    //    "myService": {
    //        "status": "DOWN",     or "status": "OUT_OF_SERVICE"
    //            "details": {
    //            "Error code:": -1
    //        }
    //    }
    @Override
    public Health health()
    {
        int errorCode = checkServices();
        if (errorCode != 0)
        {
            return Health.outOfService().withDetail("Error code:", errorCode).build();
//            return Health.down().withDetail("Error code:", errorCode).build();
        }
        return Health.up().build();
    }

    //----------------------------------------------------------------------------------------------------------
    private int checkServices()
    {
        //--- perform any health checks - could involve calling external APIs to determine health
        return -1;
    }
}
