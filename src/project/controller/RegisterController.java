package project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.MemberService;
import project.vo.Member;

public class RegisterController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
			
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty()) {
			req.setAttribute("error", "Fill every part!!!");
			HttpUtil.forward(req, resp, "/register.jsp");
		}
		
		Member member = new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setAge(age);
		

		MemberService service = MemberService.getInstance();
		service.Register(member);

		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/Login.jsp");
		
	}
}
