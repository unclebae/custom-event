package com.example.event.demoeventlistener;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        log.info("[Event Publisher] Publishing custom event. ");
        NormalCustomEvent customSpringEvent = new NormalCustomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    public void doStuffAndPublishGenericEvent(final GenericEvent evemt) {
        log.info("[Event Publisher] Publishing Generic custom event. ");
        applicationEventPublisher.publishEvent(evemt);
    }
}
