package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao =new MemberDAO();
		
		// 사용자가 데이터를 입력한 후 db로 데이터를 보낼 때 데이터를 보호하기 위한 객체
		MemberBean mbean = new MemberBean();// 사용자로부터 id값을 받아오기 위해 사용한다.
		ActionForward forward = new ActionForward();// 이동 구문
		request.setCharacterEncoding("utf-8");
		//String id = request.getParameter("id");
		System.out.println("detail id="+request.getParameter("id"));
		mbean.setId(request.getParameter("id"));// 보안을 위해서 메소드를 통해서만 데이터를 주고 받겠다.
		MemberBean detail = mdao.memberDetail(mbean);
		request.setAttribute("memberdetail",detail );// select문을 저장한 detail을 memberdetail이라는 name에 담아준다.
		// jsp에서 memberdetail을 통해서 값을 받아올수 있다.
		
		forward.setRedirect(false);
		forward.setPath("member/member_detail.jsp");
		
		return forward;
	}

}
