package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();// db연동과 관련이 있는 객체
		MemberBean mbean = new MemberBean();// 사용자가 데이터를 입력한 후 db로 데이터를 보낼 때 데이터를 보호하기 위한 객체
		ActionForward forward = new ActionForward(); // 화면이동
		mbean.setId(request.getParameter("id"));
		mdao.memberDel(mbean);
		
		forward.setRedirect(true);
		forward.setPath("MemberListAction.me");
		return forward;
	}

}
