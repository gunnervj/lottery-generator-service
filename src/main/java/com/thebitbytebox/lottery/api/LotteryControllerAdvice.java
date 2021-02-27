package com.thebitbytebox.lottery.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.thebitbytebox.lottery.bean.Error;

import com.thebitbytebox.lottery.exceptions.LotteryUnknownException;

@ControllerAdvice
public class LotteryControllerAdvice {

	@ExceptionHandler(value = LotteryUnknownException.class)
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	public @ResponseBody Error handleUnknownException(final LotteryUnknownException exception) {
		Error error = Error.builder()
							.message(exception.getMessage())
							.build();
		return error;
	}
}
