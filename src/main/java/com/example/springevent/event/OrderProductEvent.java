package com.example.springevent.event;

import org.springframework.context.ApplicationEvent;

public class OrderProductEvent extends ApplicationEvent {
    public OrderProductEvent(Object source, String orderId) {
        super(source);

        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private String orderId;
}
