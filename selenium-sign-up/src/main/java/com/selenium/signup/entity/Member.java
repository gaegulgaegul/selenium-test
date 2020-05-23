package com.selenium.signup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Table(name="MEMBER")
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sno;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTHDAY")
	private String birthday;
	
	@Column(name="GENDER")
	private int gender;
	
	@Builder
	public Member(String email
				, String password
				, String name
				, String birthday
				, int gender) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		
	}
	
	public String toString() {
		return "Member={"
				+ "sno = " + this.sno
				+ ", email = " + this.email
				+ ", password=" + this.password
				+ ", name=" + this.name
				+ ", birthday=" + this.birthday
				+ ", gender=" + this.gender
				+ "}";
	}
}
