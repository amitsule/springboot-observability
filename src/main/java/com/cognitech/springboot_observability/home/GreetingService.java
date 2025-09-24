package com.cognitech.springboot_observability.home;

import io.micrometer.core.annotation.Timed;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.NewSpan;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class GreetingService
{
    private final Tracer tracer;

    public GreetingService(Tracer tracer)
    {
        this.tracer = tracer;
    }

    @Timed(value = "do.greeting.timed.aspect")
    @NewSpan(value = "do-greeting-method-span-ant")
    public String doGreetingTimed(String user)
    {
        String result = "";
//        Span newSpan = this.tracer.nextSpan().name("do-greeting-method-span");
//        try (Tracer.SpanInScope spanInScope = this.tracer.withSpan(newSpan.start()))
//        {
//            TimeUnit.MILLISECONDS.sleep(400);
//            result = "Hello " + user;
//        }
//        catch (InterruptedException ex)
//        {
//            throw new RuntimeException(ex);
//        }
//        finally
//        {
//            newSpan.end();
//        }
        result = "Hello " + user;
        return result;
    }
}
