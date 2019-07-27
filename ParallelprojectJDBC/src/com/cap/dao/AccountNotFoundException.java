package com.cap.dao;

public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(String s) {
		super(s);
	}
}
