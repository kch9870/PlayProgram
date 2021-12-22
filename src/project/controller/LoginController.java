package project.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.service.MemberService;
import project.vo.Member;

public class LoginController implements Controller{
	ServletContext sc;
	String adminID, adminPasswd;
	public void init(ServletConfig config) {
		sc = config.getServletContext();
		adminID = sc.getInitParameter("adminID");
		adminPasswd = sc.getInitParameter("adminPWD");
	}
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		MemberService service = MemberService.getInstance();
		Member m = service.MemberLogin(id,passwd);
		
		if(m == null && id ==null) {
			req.setAttribute("error", "There is no id");
			HttpUtil.forward(req, resp, "Login.jsp");
		} 
		else if (id.equals("admin") && passwd.equals("1234")) {
			HttpUtil.forward(req, resp, "/AdminIndex.jsp");
		} 
		else {
			HttpSession s = req.getSession();
			req.setAttribute("id", id);
			HttpUtil.forward(req, resp, "/Open.jsp");
		}
		
	}
	
	
}
