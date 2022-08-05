package com.example.springevent.service;

import com.example.springevent.event.MsgEvent;
import com.example.springevent.event.OrderProductEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ApplicationContext applicationContext;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String buyOrder(String orderId) {
        long start = System.currentTimeMillis();

        applicationContext.publishEvent(new OrderProductEvent(this, orderId));

        long end = System.currentTimeMillis();
        log.info("threadId {}, completed, {} ms", Thread.currentThread().getId(), end - start);
        return "success";
    }

    public String buyOrder2(String orderId) {
        long start = System.currentTimeMillis();

        applicationContext.publishEvent(new MsgEvent(orderId));

        long end = System.currentTimeMillis();
        log.info("threadId {}, completed, {} ms", Thread.currentThread().getId(), end - start);
        return "success";
    }
}
