package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.demo","com.service","com.model","com.dao","com.controller","com.exception"})
@EntityScan("com.model")
@EnableJpaRepositories(basePackages="com.dao")
public class ProductXTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductXTest2Application.class, args);
		System.out.println("Project Started Successfully");
	}

}
