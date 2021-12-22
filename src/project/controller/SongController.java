package project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.service.MemberService;
import project.service.SongService;
import project.vo.Member;
import project.vo.Song;

public class SongController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String togo=req.getParameter("goto");
		String logid=req.getParameter("logid");
		
		if(togo.equals("toMain"))
		{
			if(logid==null)
			{
				req.setAttribute("logid",null);
			}
			else
			{
				req.setAttribute("logid",logid);
			}
			
			ArrayList<Song> list=SongService.getInstance().songBestList();
			req.setAttribute("list", list);
			req.setAttribute("logid",logid);
			req.setAttribute("name", togo);
			HttpUtil.forward(req,resp,"/Index.jsp");
		}
		else if(togo.equals("genre"))
		{
			ArrayList<Song> list=SongService.getInstance().songList();
			req.setAttribute("list", list);
			req.setAttribute("logid",logid);
			req.setAttribute("goto",togo);
			HttpUtil.forward(req,resp,"/Genre.jsp");
		}
		else if(togo.equals("genrekind"))
		{
			String kind=req.getParameter("kind");
			ArrayList<Song> list=SongService.getInstance().songKindList(kind);
			req.setAttribute("list", list);
			req.setAttribute("logid",logid);
			req.setAttribute("goto",togo);
			req.setAttribute("kind",kind);
			HttpUtil.forward(req,resp,"/Genre.jsp");
		}
		else if(togo.contentEquals("addsong"))
		{
			String a_title=req.getParameter("a_title");
			String song=req.getParameter("song");
			String singer=req.getParameter("singer");
			String kind=req.getParameter("kind");
			String audio=req.getParameter("audio");
			int scount=Integer.parseInt(req.getParameter("scount"));
			
			Song addsong = new Song();
			addsong.setA_title(a_title);
			addsong.setSong(song);
			addsong.setSinger(singer);
			addsong.setKind(kind);
			addsong.setAudio(audio);
			addsong.setS_count(scount);
			
			SongService service = SongService.getInstance();
			service.insertSong(addsong);
			
			ArrayList<Song> list=SongService.getInstance().songList();
			req.setAttribute("list", list);
			HttpUtil.forward(req,resp,"/result/MusicList.jsp");

		}
		else if(togo.contentEquals("songlist"))
		{	
			ArrayList<Song> list=SongService.getInstance().songList();
			req.setAttribute("list", list);
			HttpUtil.forward(req,resp,"/result/MusicList.jsp");
		}
		else if(togo.equals("latest"))
		{
			ArrayList<Song> list=SongService.getInstance().latestList();
			
			req.setAttribute("list", list);
			
			System.out.println(list);
			
			HttpUtil.forward(req,resp,"/Latest.jsp");

		}
	}
}