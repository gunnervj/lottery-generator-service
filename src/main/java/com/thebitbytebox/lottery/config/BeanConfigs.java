package com.thebitbytebox.lottery.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {

	@Bean
	public Random random() {
		return new Random();
	}
	
}
