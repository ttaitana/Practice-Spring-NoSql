package com.practice.joblisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.practice.joblisting.*"})
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class JoblistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoblistingApplication.class, args);
	}

}
