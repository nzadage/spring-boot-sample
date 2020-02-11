package com.github.nzadage.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.github.nzadage.spring.repository"})
public class SampleTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleTestApplication.class, args);
	}

}
