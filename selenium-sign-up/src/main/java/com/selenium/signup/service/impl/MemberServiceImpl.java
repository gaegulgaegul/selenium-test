package com.selenium.signup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenium.signup.entity.Member;
import com.selenium.signup.repository.MemberRepository;
import com.selenium.signup.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}
	
}
