package com.thoainguyen;

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
	public Consumer<String> consumeOrder() {
		return name -> System.out.println("Hello1, " + name + "," + System.currentTimeMillis());
	}
}
