package com.example.event.demoeventlistener;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class NormalCustomEvent extends ApplicationEvent {

    private String message;

    public NormalCustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
