package com.arinc.vetenaryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VetenaryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetenaryAppApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){ return new ModelMapper();

	}
}
