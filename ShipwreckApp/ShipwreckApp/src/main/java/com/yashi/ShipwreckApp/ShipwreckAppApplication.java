package com.yashi.ShipwreckApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.yashi")
@EntityScan("com.yashi.bean")
@SpringBootApplication
public class ShipwreckAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipwreckAppApplication.class, args);
	}

}
