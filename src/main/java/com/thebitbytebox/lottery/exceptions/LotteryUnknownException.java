package com.thebitbytebox.lottery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class LotteryUnknownException extends RuntimeException {
	private static final long serialVersionUID = -3966012598088542147L;
	private String errorMessage;
	
	public LotteryUnknownException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	
}
