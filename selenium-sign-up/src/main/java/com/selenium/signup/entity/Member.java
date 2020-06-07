package com.selenium.signup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name="MEMBER")
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EMAIL", length=20, nullable=false)
	private String email;
	
	@Column(name="PASSWORD", length=100, nullable=false)
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTHDAY")
	private String birthday;
	
	@Column(name="GENDER")
	private int gender;
	
	@Builder
	public Member(Long id
				, String email
				, String password
				, String name
				, String birthday
				, int gender) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		
	}
	
	public String toString() {
		return "Member={"
				+ "id = " + this.id
				+ ", email = " + this.email
				+ ", password=" + this.password
				+ ", name=" + this.name
				+ ", birthday=" + this.birthday
				+ ", gender=" + this.gender
				+ "}";
	}
}
