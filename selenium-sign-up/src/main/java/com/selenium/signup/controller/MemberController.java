package com.selenium.signup.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.selenium.signup.entity.Member;
import com.selenium.signup.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/doSignUp", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doSignUp(Member member) {
		Map<String,Object> resultMap = Maps.newHashMap();
		System.out.println(member.toString());
		try {
			memberService.save(member);
			resultMap.put("result", 1);
		} catch(Exception e) {
			resultMap.put("result", 99);
		}
		return resultMap;
	}
	
}
