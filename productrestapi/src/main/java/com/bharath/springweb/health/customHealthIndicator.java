package com.bharath.springweb.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class customHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean error=true;
        if(error)
            return Health.down().withDetail("Error occured", 123).build();
        return Health.up().build();
    }
}
