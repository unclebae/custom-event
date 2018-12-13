package com.example.event.demoeventlistener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class GenericEventListener {

    @EventListener(condition = "#event.success == false", classes = {GenericEvent.class})
    public void handleSuccessfun(GenericEvent<String> event) {
       log.info("Handling Generic Event (conditional).{} ", event);
    }
}
