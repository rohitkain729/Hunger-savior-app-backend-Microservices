package com.hunger.saviour.portal.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.hunger.saviour.portal.dtos.SignUpRequestDTO;

public interface UserService {
	String signUp(@RequestBody SignUpRequestDTO signUpRequestDTO);
    
}
