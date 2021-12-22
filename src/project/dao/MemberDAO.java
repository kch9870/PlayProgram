package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.vo.Member;

public class MemberDAO {
	private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return memberDao;
	}
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team?serverTimezone=UTC", "root", "1234");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void Register(Member member) {
		try {
			int m_code=0;
			
			Connection con = this.connect();
			PreparedStatement pstmt = con.prepareStatement("SELECT max(m_code) FROM team.member;");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				m_code = rs.getInt(1)+1;
			}
			else {
				m_code = 0;
			}
			pstmt = con.prepareStatement("insert into member values (?,?,?,?,?)");
			pstmt.setInt(1,m_code);
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getName());
			pstmt.setInt(5, member.getAge());
			
		pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Member MemberLogin(String id, String passwd) {
		Member member = null;
		try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement("select * from member where id = ? and passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	public ArrayList<Member> memberList() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null;
		try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement("select * from member");
			ResultSet rs = pstmt.executeQuery();	
			while(rs.next()) {
				member = new Member();
				member.setId(rs.getString(2));	
				member.setPasswd(rs.getString(3));
				member.setName(rs.getString(4));
				member.setAge(rs.getInt(5));
				list.add(member);	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	


	
	
	
	/*public Member memberSearch(String id) {
		Member member = null;
		try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();	
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));	
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	public void memberUpdate(Member member) {
		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement("update member set passwd=?, name=?, mail=? where id=?");
			pstmt.setString(4, member.getId());	
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			
			pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void memberDelete(Member member) {
		try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement("delete from member where id=?");
			pstmt.setString(1, member.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	
}







