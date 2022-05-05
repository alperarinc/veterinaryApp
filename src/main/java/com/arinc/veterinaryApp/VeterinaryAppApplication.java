package com.arinc.veterinaryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinaryAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(VeterinaryAppApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;

	}
}
