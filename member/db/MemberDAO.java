package net.member.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

public class MemberDAO {
	//DB ���ȭ
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
	
	// member���̺� insert�ϴ� �޼ҵ�(memberInsert)
	public void memberInsert(MemberBean mbean) {
		String sql="insert into member1(id,pw,name,gender)"
				+ " values(?,?,?,?)";
		try {
			pstmt= con.prepareStatement(sql);
			// �Ű������� ���� �Ѱ��ش�.
			pstmt.setString(1,mbean.getId());
			pstmt.setString(2,mbean.getPw());
			pstmt.setString(3,mbean.getName());
			pstmt.setString(4,mbean.getGender());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ // ���ܰ� �ִ� ���� ó���Ѵ�. ��������� �ݺ� ���ΰ�ħ�ص� ������ ���� �ʴ´�.
			if(con!=null){try{con.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
		}
		
	}// memberInsert end
	
	// member���̺� Select�ϴ� �޼ҵ�(memberSelect)
		public ArrayList<MemberBean> memberList() {
			String sql="select * from member1";
			ArrayList<MemberBean> list = new ArrayList();
			try {
				pstmt= con.prepareStatement(sql);
				// �Ű������� ���� �Ѱ��ش�.
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					MemberBean member = new MemberBean();
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setGender(rs.getString("gender"));
					list.add(member); //����Ʈ�� ����ش�.
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ // ���ܰ� �ִ� ���� ó���Ѵ�. ��������� �ݺ� ���ΰ�ħ�ص� ������ ���� �ʴ´�.
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}
			}
		return list;
	}// memberList end
	
		public MemberBean memberDetail(MemberBean mbean) {// Detail�޼ҵ� ����
			
			// member1���̺��� �� ȸ�� �� ������ ��ȸ�ϴ� ���̺�
			String sql="select * from member1 where id = ?";
			MemberBean member = null;// �ѰǸ� ó���ϸ� �Ǳ⿡ �迭�� �ʿ䰡 ����.
			
			try {
				pstmt= con.prepareStatement(sql);
				// �Ű������� ���� �Ѱ��ش�.
				System.out.println("detail����="+mbean.getId());
				pstmt.setString(1, mbean.getId());// ù��° ����ǥ�� MemberBean�� ����Ǿ� �ִ� id���� �����ͼ� �����ض�.
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					member = new MemberBean();
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setGender(rs.getString("gender"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ // ���ܰ� �ִ� ���� ó���Ѵ�. ��������� �ݺ� ���ΰ�ħ�ص� ������ ���� �ʴ´�.
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}
			}
			return member;
		}// Detail�޼ҵ� ��
	
		public void memberModify(MemberBean mbean) {// memberModify�޼��� ����
			String sql="update member1 set pw=?,name=? where id=? ";
			try {
				pstmt= con.prepareStatement(sql);
				// �Ű������� ���� �Ѱ��ش�.
				pstmt.setString(1,mbean.getPw());
				pstmt.setString(2,mbean.getName());
				pstmt.setString(3,mbean.getId());
			
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ // ���ܰ� �ִ� ���� ó���Ѵ�. ��������� �ݺ� ���ΰ�ħ�ص� ������ ���� �ʴ´�.
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			}
			
		}// memberModify�޼��� ��
		
		public void memberDel(MemberBean mbean) {// memberdel�޼��� ����
			System.out.println("bbb");
			String sql="delete from member1 where id=? ";
			try {
				pstmt= con.prepareStatement(sql);
				// �Ű������� ���� �Ѱ��ش�.
				pstmt.setString(1,mbean.getId());
	
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ // ���ܰ� �ִ� ���� ó���Ѵ�. ��������� �ݺ� ���ΰ�ħ�ص� ������ ���� �ʴ´�.
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			}
			
		}// memberdel�޼��� ��
}
