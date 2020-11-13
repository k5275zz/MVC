package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class BoardAddAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// ȸ�����԰� ���õǾ� �ִ� �������� �����ؾ� �Ǵ°͵�� DB�����ؾ� �� ���� ������ dao�� ���ؼ� ����.
		// db������ ������ �ִ� ��ü
		MemberDAO mdao =new MemberDAO();
		// ����ڰ� �����͸� �Է��� �� db�� �����͸� ���� �� �����͸� ��ȣ�ϱ� ���� ��ü
		MemberBean mbean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		//�ѱ۱�������
		request.setCharacterEncoding("utf-8");
		//���̵�
		//String id=request.getParameter("id");
		//��й�ȣ
		//String pw=request.getParameter("pw");
		//�̸�
		//String name=request.getParameter("name");
		//����
		//String gender=request.getParameter("gender");
		
		//bean���
		mbean.setId(request.getParameter("id")); // id�� bean�� ��´�.
		mbean.setPw(request.getParameter("pw")); // pw�� bean�� ��´�.
		mbean.setName(request.getParameter("name")); // name�� bean�� ��´�.
		mbean.setGender(request.getParameter("gender")); // gender�� bean�� ��´�.
		
		// insert
		mdao.memberInsert(mbean);
		
		forward.setRedirect(false);
		forward.setPath("member_list.jsp");
		return forward;
		//return null;	
	}
	
}

