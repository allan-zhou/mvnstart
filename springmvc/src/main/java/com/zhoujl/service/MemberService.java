package com.zhoujl.service;

import java.util.List;

import com.zhoujl.pojo.Member;

public interface MemberService  {
	Member getMemberById(int id);
	List<Member> getMembers();
	
	void addMember(Member member);
	void updateMember(Member member);
	void deleteMemberById(int id);
}
