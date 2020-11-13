package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class BoardAddAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 회원가입과 관련되어 있는 논리적으로 수행해야 되는것들과 DB연결해야 될 것이 있으면 dao를 통해서 연결.
		// db연동과 관련이 있는 객체
		MemberDAO mdao =new MemberDAO();
		// 사용자가 데이터를 입력한 후 db로 데이터를 보낼 때 데이터를 보호하기 위한 객체
		MemberBean mbean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		//한글깨짐방지
		request.setCharacterEncoding("utf-8");
		//아이디
		//String id=request.getParameter("id");
		//비밀번호
		//String pw=request.getParameter("pw");
		//이름
		//String name=request.getParameter("name");
		//성별
		//String gender=request.getParameter("gender");
		
		//bean방식
		mbean.setId(request.getParameter("id")); // id를 bean에 담는다.
		mbean.setPw(request.getParameter("pw")); // pw를 bean에 담는다.
		mbean.setName(request.getParameter("name")); // name를 bean에 담는다.
		mbean.setGender(request.getParameter("gender")); // gender를 bean에 담는다.
		
		// insert
		mdao.memberInsert(mbean);
		
		forward.setRedirect(false);
		forward.setPath("member_list.jsp");
		return forward;
		//return null;	
	}
	
}

