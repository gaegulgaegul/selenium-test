package com.selenium.signup.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.selenium.signup.entity.Member;
import com.selenium.signup.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class MemberController {
	
	private MemberRepository memebrRepositroy;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/doSignUp")
	@ResponseBody
	public Map<String,Object> doSignUp(@Valid Member member) {
		Map<String,Object> resultMap = Maps.newHashMap();
		System.out.println(member.toString());
		try {
			memebrRepositroy.save(member);
			resultMap.put("result", 1);
		} catch(Exception e) {
			resultMap.put("result", 99);
		}
		return resultMap;
	}
	
}
