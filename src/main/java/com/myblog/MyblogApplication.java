package com.myblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class MyblogApplication {

	public static void main(String[] args) {
		run(MyblogApplication.class, args);
	}
@Bean
public ModelMapper getModelMapper(){
		return new ModelMapper();
}
}

