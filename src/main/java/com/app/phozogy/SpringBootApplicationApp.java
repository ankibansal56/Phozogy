package com.app.phozogy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app.phozogy")
public class SpringBootApplicationApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationApp.class, args);
	}
}