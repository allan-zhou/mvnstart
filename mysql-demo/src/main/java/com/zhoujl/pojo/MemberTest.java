package com.zhoujl.pojo;

import com.zhoujl.pojo.Member;
import java.util.ArrayList;
import com.zhoujl.utils.SqlHelper;
import java.lang.reflect.Array;

public class MemberTest {

	public static void addMember() {
		String sql = "INSERT INTO member (member_id, member_name, member_email, member_mobile) VALUES (?,?,?,?)";  
        String[] parameters = { "3", "张三", "zhangsan@qq.com", "13522226666" };  
        SqlHelper.executeUpdate(sql, parameters);  
	}
	
	public static void printAll() {
		String sql = "select * from member";
		ArrayList al = SqlHelper.executeQuery(sql, null);
		System.out.println("查询所有用户");		
		
		for (Object obj: al) {			
			if(obj.getClass().isArray()) {
				int length = Array.getLength(obj);
			    for (int i = 0; i < length; i++) {
			    	System.out.print(Array.get(obj, i) + "  ");
			    	
			    }
			    System.out.println();
			}
		}
	}
}
