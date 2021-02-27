package com.thebitbytebox.lottery.service;

import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebitbytebox.lottery.bean.LotteryResponse;
import com.thebitbytebox.lottery.config.LotteryConfigurationProperties;
import com.thebitbytebox.lottery.exceptions.LotteryUnknownException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LotteryGeneratorServiceImpl implements LotteryGeneratorService {

	private LotteryConfigurationProperties configProperties;
	private Random randomDigitGenerator;

	@Autowired
	public LotteryGeneratorServiceImpl(Random random, LotteryConfigurationProperties configProperties) {
		this.randomDigitGenerator = random;
		this.configProperties = configProperties;
	}

	@Override
	public LotteryResponse generateALottery() {
		LotteryResponse.LotteryResponseBuilder responseBuilder = LotteryResponse.builder();
		
		try {
			String number = randomDigitGenerator.ints(configProperties.getNumberCount(), 
													configProperties.getLowerLimit(),
													configProperties.getUpperLimit())
												.boxed()
												.map(String::valueOf)
												.collect(Collectors.joining(" "));
			responseBuilder.lotteryNumber(number);
		} catch (Exception ex) {
			log.error("Error While generating Lottery Ticket : " + ex.getMessage(), ex);
			throw new LotteryUnknownException("Error happened while generating lottery ticket. Please try again");
		}

		return responseBuilder.build();
	}

}
