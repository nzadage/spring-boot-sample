package com.github.nzadage.spring.security;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.nzadage.spring.beans.User;
import com.github.nzadage.spring.repository.UserRepository;

@Component("DbAuthenticator")
public class DBBasedAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static final Logger log = LoggerFactory.getLogger(DBBasedAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		log.info("Authentication Started. ");
		String username = auth.getName();
		User user = userRepository.findByUsername(username);
		String password = auth.getCredentials().toString();
		log.info("Username is "+username+" and password is [encrypted]");
		if (username != null && !username.equalsIgnoreCase("") 
				&& password != null && !password.equalsIgnoreCase("") && 
				bCryptPasswordEncoder.matches(password, user.getPassword())) {
			
			log.info("Authentication is successful...");
			return new UsernamePasswordAuthenticationToken
					(username, password, Collections.emptyList());
		} else {
			throw new
			BadCredentialsException("External system authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Bean
	private BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
