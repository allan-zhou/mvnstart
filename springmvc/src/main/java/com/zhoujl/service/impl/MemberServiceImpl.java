package com.zhoujl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoujl.mapper.MemberMapper;
import com.zhoujl.pojo.Member;
import com.zhoujl.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;//注入dao
	
	public Member getMemberById(int id) {
		return memberMapper.findMemberById(id);
	}

	public List<Member> getMembers() {
		return memberMapper.findAllMembers();
	}

	public void addMember(Member member) {
		memberMapper.insertMember(member);
	}

	public void updateMember(Member member) {
		memberMapper.updateMember(member);
	}

	public void deleteMemberById(int id) {
		memberMapper.deleteMember(id);
	}
}
