package net.member.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

public class MemberDAO {
	//DB 모듈화
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	
	public MemberDAO(){

		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	// member테이블에 insert하는 메소드(memberInsert)
	public void memberInsert(MemberBean mbean) {
		String sql="insert into member1(id,pw,name,gender)"
				+ " values(?,?,?,?)";
		try {
			pstmt= con.prepareStatement(sql);
			// 매개변수를 통해 넘겨준다.
			pstmt.setString(1,mbean.getId());
			pstmt.setString(2,mbean.getPw());
			pstmt.setString(3,mbean.getName());
			pstmt.setString(4,mbean.getGender());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if(con!=null){try{con.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
		}
		
	}// memberInsert end
	
	// member테이블에 Select하는 메소드(memberSelect)
		public ArrayList<MemberBean> memberList() {
			String sql="select id,pw,name,gender from member1";
			ArrayList<MemberBean> list = new ArrayList();
			try {
				pstmt= con.prepareStatement(sql);
				// 매개변수를 통해 넘겨준다.
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					MemberBean member = new MemberBean();
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setGender(rs.getString("gender"));
					list.add(member); //리스트에 담아준다.
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}
			}
		return list;
	}// memberList end
	

	
}
