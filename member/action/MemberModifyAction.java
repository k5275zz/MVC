package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();// db������ ������ �ִ� ��ü
		MemberBean mbean = new MemberBean();// ����ڰ� �����͸� �Է��� �� db�� �����͸� ���� �� �����͸� ��ȣ�ϱ� ���� ��ü
		ActionForward forward = new ActionForward(); // ȭ���̵�
		System.out.println("������� ����");
		request.setCharacterEncoding("utf-8");
		// ���̵� where����
		mbean.setId(request.getParameter("id"));
		// ��й�ȣ set����
		mbean.setPw(request.getParameter("pw"));
		// �̸� set����
		mbean.setName(request.getParameter("name"));
		// ����
		mbean.setGender(request.getParameter("gender"));
		// ȸ������������ �ϱ� ���� memberModify�޼��� ȣ��
		mdao.memberModify(mbean);
		System.out.println(request.getParameter("ȸ������ �����Ϸ�")); 
		
		 System.out.println("�����Ͼ׼� ����");
		 System.out.println(request.getParameter("id"));
		 forward.setRedirect(true);
		 forward.setPath("MemberDetailAction.me?id="+request.getParameter("id"));
		 
		 return forward;
		 
	}

}
