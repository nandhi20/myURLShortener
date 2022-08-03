package com.URL.shortener.service;

import java.util.Random;

public class Encoder {

	static String generateCode() {
		String shortUrl = new String();
		String combinations = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqurstvwxyz0123456789";
		int length = 7;
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			shortUrl += combinations.charAt(r.nextInt(combinations.length()));
		}
		return shortUrl;
	}
}
