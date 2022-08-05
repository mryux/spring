package com.example.springevent.listener;

import com.example.springevent.event.OrderProductEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {
    private static final Logger log = LoggerFactory.getLogger(OrderProductListener.class);

    @Async
    @Override
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();
        long start = System.currentTimeMillis();

        log.info("threadId {}, check order {} start", Thread.currentThread().getId(), orderId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        log.info("threadId {}, check order {}, takes {} ms", Thread.currentThread().getId(), orderId, end-start);
    }
}
