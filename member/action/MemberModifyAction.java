package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();// db연동과 관련이 있는 객체
		MemberBean mbean = new MemberBean();// 사용자가 데이터를 입력한 후 db로 데이터를 보낼 때 데이터를 보호하기 위한 객체
		ActionForward forward = new ActionForward(); // 화면이동
		System.out.println("모디파이 실행");
		request.setCharacterEncoding("utf-8");
		// 아이디 where절에
		mbean.setId(request.getParameter("id"));
		// 비밀번호 set절에
		mbean.setPw(request.getParameter("pw"));
		// 이름 set절에
		mbean.setName(request.getParameter("name"));
		// 성별
		mbean.setGender(request.getParameter("gender"));
		// 회원정보수정을 하기 위한 memberModify메서드 호출
		mdao.memberModify(mbean);
		System.out.println(request.getParameter("회원정보 수정완료")); 
		
		 System.out.println("디테일액션 시작");
		 System.out.println(request.getParameter("id"));
		 forward.setRedirect(true);
		 forward.setPath("MemberDetailAction.me?id="+request.getParameter("id"));
		 
		 return forward;
		 
	}

}
