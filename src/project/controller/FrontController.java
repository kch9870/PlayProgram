package project.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException {	
		list = new HashMap<String, Controller>();
		list.put("/register.do", new RegisterController());
		list.put("/login.do", new LoginController());
		list.put("/song.do", new SongController());
		list.put("/playlist.do", new PlayListController());
		list.put("/playlistdelete.do", new PlayListController());
		list.put("/search.do", new SearchController());
		list.put("/member.do", new MemberListController());
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();		
		String cp = req.getContextPath();			
		String path = url.substring(cp.length(), url.length());	
		
		Controller sc = list.get(path);	
		sc.execute(req, resp);
	}
}
