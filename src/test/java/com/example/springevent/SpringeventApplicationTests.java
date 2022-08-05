package com.example.springevent;

import com.example.springevent.service.OrderService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringeventApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(SpringeventApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Autowired
	private OrderService orderService;

	@Test
	public void buyOrderTest() {
		log.info("thread id {}", Thread.currentThread().getId());
		orderService.buyOrder("12344");
		log.info("completed.");
	}

	@Test
	public void buyOrder2Test() {
		log.info("thread id {}", Thread.currentThread().getId());
		orderService.buyOrder2("12344");
		log.info("completed.");
	}
}
