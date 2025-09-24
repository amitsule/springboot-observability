package com.cognitech.springboot_observability.home;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController
{
    private final Timer greetingTimer;
    private final GreetingService greetingService;

    public GreetingController(MeterRegistry meterRegistry, GreetingService greetingService)
    {
        this.greetingTimer = meterRegistry.timer("do.greeting.timed", "labelgreeting", "valuegreeting");
        this.greetingService = greetingService;
    }

    @GetMapping
    public String helloWorld()
    {
        return "Hello Spring Observability";
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping("/{user}")
    public String helloGreeting(@PathVariable String user)
    {
//        return this.greetingTimer.record(() -> doGreeting(user));
        return this.greetingService.doGreetingTimed(user);
    }

    //----------------------------------------------------------------------------------------------------------
    private String doGreeting(String user)
    {
        //--- Will use greetingTimer and "do.greeting.timed" metric
        return "Hello " + user;
    }
}
