import java.util.List;

import com.zhoujl.pojo.Member;
import com.zhoujl.service.MemberService;

public class App {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		
        List<Member> list =	service.findAllMembers();
        System.out.println(list.size());
        for(Member mitem:list) {
        	App.printMember(mitem);
        } 
        
        Member m = new Member();
        m.setId(5);
        m.setName("test");
        m.setEmail("test@qq.com");
        m.setMobile("15911223344");
        service.insertMember(m);
        App.printMember(m);
        
        list =	service.findAllMembers();
        System.out.println(list.size());
        for(Member mitem:list) {
        	App.printMember(mitem);
        } 
        
        Member m2 = service.findMemberById(5);
        m2.setName("test+2");
        service.updateMember(m2);
        App.printMember(m2);
       
        list =	service.findAllMembers();
        System.out.println(list.size());
        for(Member mitem:list) {
        	App.printMember(mitem);
        } 
        
        service.deleteMember(5);
        list =	service.findAllMembers();
        System.out.println(list.size());
        for(Member mitem:list) {
        	App.printMember(mitem);
        } 
        
	}
	
	public static void printMember(Member m) {
		System.out.println("ID:" + m.getId() + ", 姓名："+ m.getName() + ", 邮箱："+ m.getEmail() + ", 手机："+ m.getMobile());
	}
	
}
