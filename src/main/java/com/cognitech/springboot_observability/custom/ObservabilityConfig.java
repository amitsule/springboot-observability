package com.cognitech.springboot_observability.custom;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.DefaultNewSpanParser;
import io.micrometer.tracing.annotation.ImperativeMethodInvocationProcessor;
import io.micrometer.tracing.annotation.MethodInvocationProcessor;
import io.micrometer.tracing.annotation.NewSpanParser;
import io.micrometer.tracing.annotation.SpanAspect;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservabilityConfig
{
    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry)
    {
        return new ObservedAspect(observationRegistry);
    }

    //----------------------------------------------------------------------------------------------------------
    @Bean
    TimedAspect timedAspect(MeterRegistry meterRegistry)
    {
        return new TimedAspect(meterRegistry);
    }

    //----------------------------------------------------------------------------------------------------------
    @Bean
    SpanAspect spanAspect(MethodInvocationProcessor processor)
    {
        return new SpanAspect(processor);
    }

    //----------------------------------------------------------------------------------------------------------
    @Bean
    MethodInvocationProcessor methodInvocationProcessor(NewSpanParser parser, Tracer tracer, BeanFactory beanFactory)
    {
        return new ImperativeMethodInvocationProcessor(parser, tracer, beanFactory::getBean, beanFactory::getBean);
    }

    //----------------------------------------------------------------------------------------------------------
    @Bean
    NewSpanParser newSpanParser()
    {
        return new DefaultNewSpanParser();
    }
}
