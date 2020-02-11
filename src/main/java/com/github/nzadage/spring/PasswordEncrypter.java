package com.github.nzadage.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
		System.out.println(encoder.matches("admin", "$2a$10$xcEIEHElMjmaYEEEzM4UyuG67FJHfUQFjr4slakRigZClYk3IGYyC"));
	}
}
