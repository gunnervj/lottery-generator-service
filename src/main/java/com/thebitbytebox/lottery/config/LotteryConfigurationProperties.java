package com.thebitbytebox.lottery.config;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties(prefix = "lottery")
@Getter
@Setter
public class LotteryConfigurationProperties {
	private Integer lowerLimit = 0;
	private Integer upperLimit = 8;
	private Integer numberCount = 6;
}
