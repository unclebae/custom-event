package com.example.event.demoeventlistener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class NormalCustomEventListener implements ApplicationListener<NormalCustomEvent> {
    @Override
    public void onApplicationEvent(NormalCustomEvent customSpringEvent) {
       log.info("[Listener] Received normal custom event: " + customSpringEvent.getMessage());
    }
}
