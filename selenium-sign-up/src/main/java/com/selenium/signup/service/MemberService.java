package com.selenium.signup.service;

import org.springframework.stereotype.Service;

import com.selenium.signup.entity.Member;

@Service
public interface MemberService {
	
	public Member save(Member member);
	
}
