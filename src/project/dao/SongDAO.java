package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.vo.Member;
import project.vo.PlayList;
import project.vo.Song;


public class SongDAO {
	private static SongDAO productDao = new SongDAO();
	
	private SongDAO() {}
	
	public static SongDAO getInstance()
	{
		return productDao;
	}
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team?serverTimezone=UTC", "root", "1234");
		}catch(Exception e)
		{			
			e.printStackTrace();
		}
		return conn;
	}
	public ArrayList<Song> songList()
	{
		ArrayList<Song> list=new ArrayList<Song>();
		Song song=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = connect();
			pstmt = con.prepareStatement("select * from song");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				song = new Song();
				song.setS_code(Integer.parseInt(rs.getString(1)));
				song.setA_title(rs.getString(2));
				song.setSong(rs.getString(3));
				song.setSinger(rs.getString(4));
				song.setKind(rs.getString(5));
				song.setAudio(rs.getString(6));
				song.setS_count(Integer.parseInt(rs.getString(7)));
				list.add(song);		
			}
		}catch(SQLException se) {
	         throw new RuntimeException(
	                 "A database error occurred"+se.getMessage());
	        }
		return list;
	}
	public ArrayList<Song> songKindList(String kind)
	{
		ArrayList<Song> list=new ArrayList<Song>();
		Song song=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = connect();
			pstmt = con.prepareStatement("select * from song where kind=?");
			pstmt.setString(1,kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				song = new Song();
				song.setS_code(Integer.parseInt(rs.getString(1)));
				song.setA_title(rs.getString(2));
				song.setSong(rs.getString(3));
				song.setSinger(rs.getString(4));
				song.setKind(rs.getString(5));
				song.setAudio(rs.getString(6));
				song.setS_count(Integer.parseInt(rs.getString(7)));
				list.add(song);		
			}
		}catch(SQLException se) {
	         throw new RuntimeException(
	                 "A database error occurred"+se.getMessage());
	        }
		return list;
	}
	public ArrayList<Song> songBestList()
	   {
	      ArrayList<Song> list=new ArrayList<Song>();
	      Song song=null;
	      try {
	         Connection con = connect();
	         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM song order by s_count desc;");
	         ResultSet rs = pstmt.executeQuery();
	         for(int i=0;i<8;i++)
	         {           
	        	 if(rs.next()) {
	        		 song = new Song();
	        		 song.setS_code(Integer.parseInt(rs.getString(1)));
	        		 song.setA_title(rs.getString(2));
	        		 song.setSong(rs.getString(3));
	        		 song.setSinger(rs.getString(4));
	        		 song.setKind(rs.getString(5));
	        		 song.setAudio(rs.getString(6));
	        		 song.setS_count(Integer.parseInt(rs.getString(7)));
	        		 list.add(song);
	        		 }
	         }
	      }catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return list;
	   }
	 public void insertPlayList(String id, int s_code)
		{
		   	int p_code=0;
			try {
				Connection con = this.connect();
				
	          
				PreparedStatement pstmt = con.prepareStatement("SELECT max(p_code) FROM team.playlist;");
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					p_code = rs.getInt(1)+1;
				}
				else {
					p_code = 0;
				}
				pstmt = con.prepareStatement("insert into playlist values(?,?,?)");
				pstmt.setInt(1, p_code);
				pstmt.setString(2, id);
				pstmt.setInt(3, s_code);
				pstmt.executeUpdate();
		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	 public ArrayList<PlayList> showPlaylist(String id){
		   ArrayList<PlayList> list=new ArrayList<PlayList>();
		   ArrayList<String> Slist = new ArrayList<String>();//songlist
		   ArrayList<String> Plist = new ArrayList<String>();//playlist
		   PlayList playlist=null;
		   Song song=null;
		   try {
			   Connection con = this.connect();
			   PreparedStatement pstmt = con.prepareStatement("select *from team.playlist where id = ?;");
			   pstmt.setString(1, id);
			   ResultSet rs = pstmt.executeQuery();
			   while(rs.next()) {
				   Plist.add(rs.getString(1));//p_code
				   Slist.add(rs.getString(3));//s_code
			   }
			   for(int i = 0; i<Slist.size();i++) {
				   pstmt = con.prepareStatement("select * from team.song where s_code = ?;");
				   pstmt.setString(1,Slist.get(i));
				   rs = pstmt.executeQuery();
				   while(rs.next()) {
					   song = new Song();
					   song.setS_code(Integer.parseInt(rs.getString(1)));
		        		 song.setA_title(rs.getString(2));
		        		 song.setSong(rs.getString(3));
		        		 song.setSinger(rs.getString(4));
		        		 song.setKind(rs.getString(5));
		        		 song.setAudio(rs.getString(6));
		        		 song.setS_count(Integer.parseInt(rs.getString(7)));
		        		 playlist=new PlayList();
		        		 playlist.setP_code(Integer.parseInt(Plist.get(i)));
		        		 playlist.setSong(song);
			             list.add(playlist);     
				   }
			   }
		   }catch(Exception e)
			{
				e.printStackTrace();
			}
		   return list;
	   }
	 public void playListDelete(String p_code)
	   {
		   try {
			   
			   Connection con = this.connect();
			   
			   PreparedStatement pstmt = con.prepareStatement("delete from team.playlist where p_code=?;");
			   pstmt.setString(1,p_code);
			   pstmt.executeUpdate();
			   }
		   catch(Exception e)
			{
				e.printStackTrace();
			}
	   }
	 public ArrayList<Song> Search(String searchname)
		{
			ArrayList<Song> list=new ArrayList<Song>();
			Song s=null;
			ResultSet rs=null;
			PreparedStatement pstmt=null;
			Connection con=null;
			try {
				con = connect();
				pstmt = con.prepareStatement("select * from team.song where song like ? or singer like ?;");
				String searchString = "%"+searchname+"%";
				pstmt.setString(1, searchString);
				pstmt.setString(2, searchString);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					s = new Song();
					s.setS_code(Integer.parseInt(rs.getString(1)));
					s.setA_title(rs.getString(2));
					s.setSong(rs.getString(3));
					s.setSinger(rs.getString(4));
					s.setKind(rs.getString(5));
					s.setAudio(rs.getString(6));
					s.setS_count(Integer.parseInt(rs.getString(7)));
					list.add(s);		
				}
			}catch(SQLException se) {
		         throw new RuntimeException(
		                 "A database error occurred"+se.getMessage());
		        }
			return list;
		}
	 public void insertSong(Song song) {
			try {
				int s_code=0;
				
				Connection con = this.connect();
				PreparedStatement pstmt = con.prepareStatement("SELECT max(s_code) FROM team.song;");
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					s_code = rs.getInt(1)+1;
				}
				else {
					s_code = 0;
				}
				pstmt = con.prepareStatement("insert into song values (?,?,?,?,?,?,?,now())");
				pstmt.setInt(1,s_code);
				pstmt.setString(2, song.getA_title());
				pstmt.setString(3, song.getSong());
				pstmt.setString(4, song.getSinger());
				pstmt.setString(5, song.getKind());
				pstmt.setString(6, song.getAudio());
				pstmt.setInt(7, song.getS_count());
				
			pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Song> latestList()
	   {
	      ArrayList<Song> list=new ArrayList<Song>();
	      Song song=null;
	      try {
	         Connection con = connect();
	         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM song order by time desc;");
	         ResultSet rs = pstmt.executeQuery();
	         for(int i=0;i<11;i++)
	         {           
	        	 if(rs.next()) {
	        		 song = new Song();
	        		 song.setS_code(Integer.parseInt(rs.getString(1)));
	        		 song.setA_title(rs.getString(2));
	        		 song.setSong(rs.getString(3));
	        		 song.setSinger(rs.getString(4));
	        		 song.setKind(rs.getString(5));
	        		 song.setAudio(rs.getString(6));
	        		 song.setS_count(Integer.parseInt(rs.getString(7)));
	        		 list.add(song);
	        		 }
	         }
	      }catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return list;
	   }
	 
}
