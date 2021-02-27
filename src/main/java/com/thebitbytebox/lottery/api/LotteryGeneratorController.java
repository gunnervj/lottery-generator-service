package com.thebitbytebox.lottery.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebitbytebox.lottery.bean.LotteryResponse;
import com.thebitbytebox.lottery.service.LotteryGeneratorService;

@RestController
@RequestMapping("lottery")
public class LotteryGeneratorController implements LotteryGeneratorApi {
	private LotteryGeneratorService lotteryGeneratorService;
	
	@Autowired
	public LotteryGeneratorController(LotteryGeneratorService lotteryGeneratorService) {
		this.lotteryGeneratorService = lotteryGeneratorService;
	}

	@GetMapping(path = "/generate")
	@Override
	public LotteryResponse generateLottery() {
		LotteryResponse response;
		
		response = lotteryGeneratorService.generateALottery();
		
		return response;
	}
	

}
