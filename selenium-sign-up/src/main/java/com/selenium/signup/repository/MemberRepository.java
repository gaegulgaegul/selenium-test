package com.selenium.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selenium.signup.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}
