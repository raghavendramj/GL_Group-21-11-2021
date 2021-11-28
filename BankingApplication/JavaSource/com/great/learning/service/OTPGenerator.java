package com.great.learning.service;

public class OTPGenerator {
	public int generateOTP() {
		int randomPIN = (int) (Math.random() * 9000) + 1000;
		return randomPIN;
	}
}
