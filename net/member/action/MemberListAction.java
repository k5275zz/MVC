package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 디비 연결
		MemberDAO mdao =new MemberDAO();
		
		// MemberBean mbean = new MemberBean(); 필요없다. ?가 없다. 굳이 사용자한테 받아올게없다.
		ArrayList<MemberBean> list = new ArrayList();
		ActionForward forward = new ActionForward();
		
		//한글깨짐방지 필요없지만 무조건 넣어주는게 좋다.
		request.setCharacterEncoding("utf-8");
		list = mdao.memberList();
		request.setAttribute("memberlist", list);
		
		forward.setRedirect(false);
		forward.setPath("member_list.jsp");
		
		return forward;
	}
}
