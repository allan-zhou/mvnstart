package com.zhoujl.dao;

import java.util.List;

import com.zhoujl.pojo.Member;;

public interface MemberMapper {
	List<Member> findAllMembers();
	Member findMemberById(int id);
	
	void insertMember(Member member);
    void updateMember(Member member);
    void deleteMember(int id);
}