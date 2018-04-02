package com.zhoujl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoujl.dao.MemberMapper;
import com.zhoujl.pojo.Member;
import com.zhoujl.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;//注入dao
	
	public Member getMemberById(int id) {
		return memberMapper.findMemberById(id);
	}
}
