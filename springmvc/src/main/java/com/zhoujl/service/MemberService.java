package com.zhoujl.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


import com.zhoujl.util.MyBatisSqlSessionFactory;
import com.zhoujl.pojo.Member;
import com.zhoujl.mapper.MemberMapper;

public class MemberService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Member> findAllMembers(){
		logger.debug("findAllMembers");
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			return memberMapper.findAllMembers();
		} finally {
			sqlSession.close();
		}
	}
	
	public Member findMemberById(int id) {
		logger.debug("findMemberById: " + id);
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			return memberMapper.findMemberById(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertMember(Member member) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			memberMapper.insertMember(member);
			sqlSession.commit();
			
			logger.debug("insertMember succ!");
		} finally {
			sqlSession.close();
		}
	}
	
    public void updateMember(Member member) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			memberMapper.updateMember(member);
			sqlSession.commit();
			
			logger.debug("updateMember succ!");
		} finally {
			sqlSession.close();
		}
    }
    
    public void deleteMember(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			memberMapper.deleteMember(id);
			sqlSession.commit();
			
			logger.debug("deleteMember succ!");
		} finally {
			sqlSession.close();
		}
    }
}
