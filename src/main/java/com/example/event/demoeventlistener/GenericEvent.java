package com.example.event.demoeventlistener;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class GenericEvent<T> {

    private T what;
    protected  boolean success;

    public GenericEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }

}
