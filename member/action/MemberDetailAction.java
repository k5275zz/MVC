package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao =new MemberDAO();
		
		// ����ڰ� �����͸� �Է��� �� db�� �����͸� ���� �� �����͸� ��ȣ�ϱ� ���� ��ü
		MemberBean mbean = new MemberBean();// ����ڷκ��� id���� �޾ƿ��� ���� ����Ѵ�.
		ActionForward forward = new ActionForward();// �̵� ����
		request.setCharacterEncoding("utf-8");
		//String id = request.getParameter("id");
		System.out.println("detail id="+request.getParameter("id"));
		mbean.setId(request.getParameter("id"));// ������ ���ؼ� �޼ҵ带 ���ؼ��� �����͸� �ְ� �ްڴ�.
		MemberBean detail = mdao.memberDetail(mbean);
		request.setAttribute("memberdetail",detail );// select���� ������ detail�� memberdetail�̶�� name�� ����ش�.
		// jsp���� memberdetail�� ���ؼ� ���� �޾ƿü� �ִ�.
		
		forward.setRedirect(false);
		forward.setPath("member/member_detail.jsp");
		
		return forward;
	}

}
