package project.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
