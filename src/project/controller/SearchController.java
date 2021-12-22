package project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.SongService;
import project.vo.Song;

public class SearchController implements Controller{
   
   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String searchname = req.getParameter("searchname");
      
      ArrayList<Song> list=SongService.getInstance().Search(searchname);
	  
	  req.setAttribute("list",list);
	  HttpUtil.forward(req, resp, "/result/SearchOutput.jsp");
      
   }
}