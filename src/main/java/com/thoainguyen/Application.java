package com.thoainguyen;

import com.thoainguyen.rest.Order;
import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Consumer<Order> consumeOrder() {
		return (order) -> System.out.println("Consuming order:, " + order + "," + System.currentTimeMillis());
	}
}
