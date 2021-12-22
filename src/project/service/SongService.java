package project.service;

import java.util.ArrayList;

import project.dao.SongDAO;
import project.vo.Member;
import project.vo.PlayList;
import project.vo.Song;


public class SongService {
	private static SongService service = new SongService();
	public SongDAO dao = SongDAO.getInstance();
	private SongService(){}
	
	public static SongService getInstance() {
		return service;
	}
	public ArrayList<Song> songList()
	{
		return dao.songList();
	}
	public ArrayList<Song> songKindList(String kind)
	{
		return dao.songKindList(kind);
	}
	public ArrayList<Song> songBestList()
	{
		return dao.songBestList();
	}
	public void insertPlayList(String id, int s_code)
	{
		dao.insertPlayList(id, s_code);
	}
	public ArrayList<PlayList> showPlaylist(String id){
		 return dao.showPlaylist(id);
	}
	public void playListDelete(String p_code)
	{
		dao.playListDelete(p_code);
	}
	public ArrayList<Song>Search(String searchname)
	{
		return dao.Search(searchname);
	}
	public void insertSong(Song song)
	{
		dao.insertSong(song);
	}
	public ArrayList<Song> latestList()
	{
		return dao.latestList();
	}
}