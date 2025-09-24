package com.cognitech.springboot_observability.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AnotherServiceHealthIndicator implements HealthIndicator
{
    @Override
    public Health health()
    {
        return Health.status("CRITICAL").withDetail("Critical error code", "000").build();
    }
}
