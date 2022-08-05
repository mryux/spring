package com.example.springevent.listener;

import com.example.springevent.event.MsgEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {
    private static final Logger log = LoggerFactory.getLogger(MsgListener.class);

    @Async
    @EventListener(MsgEvent.class)
    public void sendMsg(MsgEvent event) {
        String orderId = event.getOrderId();
        long start = System.currentTimeMillis();

        log.info("threadId {}, send message start", Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        log.info("threadId {}, send message {}, {} ms", Thread.currentThread().getId(), orderId, (end-start));
    }
}
