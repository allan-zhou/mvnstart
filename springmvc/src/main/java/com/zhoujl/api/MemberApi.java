package com.zhoujl.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoujl.constant.ApiResult;
import com.zhoujl.pojo.Member;
import com.zhoujl.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/members")
public class MemberApi {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public String getMembers() throws JsonProcessingException {
		
		MemberService service = new MemberService();
		List<Member> members = service.findAllMembers();
		
				
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(members);  
		return json;
	}
	
	/*
	 * demo: /api/members/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public String getMemberById(@PathVariable("id") int id) throws JsonProcessingException {
		logger.debug(String.valueOf(id));
		
		MemberService service = new MemberService();
		Member member = service.findMemberById(id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(member);  
		return json;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json; charset=utf-8" }) 
	@ResponseBody
	public String createMember(@RequestBody Member member) throws JsonProcessingException {
		logger.debug(member.toString());
		
		MemberService service = new MemberService();
		service.insertMember(member);
		
		
		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);  
		return json;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json; charset=utf-8" }) 
	@ResponseBody
	public String updateMember(@PathVariable("id") int id, @RequestBody Member member) throws JsonProcessingException {
		logger.debug(member.toString());
		
		MemberService service = new MemberService();
		Member oldMember = service.findMemberById(id);
		
		if(member.getName() != null) {
			oldMember.setName(member.getName());
		}
		if(member.getEmail() != null) {
			oldMember.setEmail(member.getEmail());
		}
		if(member.getMobile() != null) {
			oldMember.setMobile(member.getMobile());
		}
		service.updateMember(oldMember);
		
		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);  
		return json;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json; charset=utf-8" }) 
	@ResponseBody
	public String deleteMember(@PathVariable("id") int id) throws JsonProcessingException {
		
		MemberService service = new MemberService();
		service.deleteMember(id);
		
		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);  
		return json;
	}
}
