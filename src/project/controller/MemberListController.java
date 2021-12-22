package project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.MemberService;
import project.vo.Member;

public class MemberListController implements Controller{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ArrayList<Member> list = MemberService.getInstance().memberList();
		
		req.setAttribute("list", list);
		
		System.out.println(list.get(0));
		
		HttpUtil.forward(req, resp, "/result/MemberListOutput.jsp");
	}

}
