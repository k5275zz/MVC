package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();// db������ ������ �ִ� ��ü
		MemberBean mbean = new MemberBean();// ����ڰ� �����͸� �Է��� �� db�� �����͸� ���� �� �����͸� ��ȣ�ϱ� ���� ��ü
		ActionForward forward = new ActionForward(); // ȭ���̵�
		mbean.setId(request.getParameter("id"));
		mdao.memberDel(mbean);
		
		forward.setRedirect(true);
		forward.setPath("MemberListAction.me");
		return forward;
	}

}
