package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// ��� ����
		MemberDAO mdao =new MemberDAO();
		
		// MemberBean mbean = new MemberBean(); �ʿ����. ?�� ����. ���� ��������� �޾ƿðԾ���.
		ArrayList<MemberBean> list = new ArrayList();
		ActionForward forward = new ActionForward();
		
		//�ѱ۱������� �ʿ������ ������ �־��ִ°� ����.
		request.setCharacterEncoding("utf-8");
		list = mdao.memberList();
		request.setAttribute("memberlist", list);
		
		forward.setRedirect(false);
		forward.setPath("member_list.jsp");
		
		return forward;
	}
}
