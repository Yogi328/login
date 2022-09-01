package com.prodapt.demo.exceptions;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvalidCredentialsException extends Exception{
	
	private String message;
}