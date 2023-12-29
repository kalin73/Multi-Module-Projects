package org.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "org.example.*" })
@EntityScan(basePackages = ("org.example.*"))
@EnableJpaRepositories(basePackages = { "org.example.*" })
public class HMSApplication {
	public static void main(String[] args) {
		SpringApplication.run(HMSApplication.class);
	}
}
