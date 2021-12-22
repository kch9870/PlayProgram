package project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.service.SongService;
import project.vo.Member;
import project.vo.PlayList;
import project.vo.Song;

public class PlayListController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id=req.getParameter("logid");
		String where=req.getParameter("where");
		SongService service = SongService.getInstance();
		
		if(where.equals("plist")) {
			int s_code=Integer.parseInt(req.getParameter("s_code"));
			service.insertPlayList(id, s_code);	
			
			service.showPlaylist(id);	
			ArrayList<PlayList> list = service.showPlaylist(id);
			req.setAttribute("list",list);
			req.setAttribute("logid",id);
			HttpUtil.forward(req,resp,"/result/PlayList.jsp");
		}
		else if(where.equals("play"))
		{
			String play=req.getParameter("play");
			String a_title=req.getParameter("a_title");
			String song=req.getParameter("song");
			String singer=req.getParameter("singer");
			
			req.setAttribute("play",play);
			req.setAttribute("a_title",a_title);
			req.setAttribute("song",song);
			req.setAttribute("singer",singer);
			HttpUtil.forward(req,resp,"Play.jsp");
		}
		else
		{
			String p_code=req.getParameter("p_code");
			service.playListDelete(p_code);
			
			service.showPlaylist(id);	
			ArrayList<PlayList> list = service.showPlaylist(id);
			req.setAttribute("list",list);
			req.setAttribute("logid",id);
			HttpUtil.forward(req,resp,"/result/PlayList.jsp");
		}	
	}
}
