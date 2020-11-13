package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.ProtectedFunctionMapper;




public class MemberFrontController extends HttpServlet implements javax.servlet.Servlet{
	
       protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   String RequestURI=request.getRequestURI();
    	   String contextPath=request.getContextPath();
    	   String command=RequestURI.substring(contextPath.length());
    	   
    	   System.out.println("RequestURI :"+RequestURI);
    	   System.out.println("contextPath :"+contextPath);
    	   System.out.println("command :"+command);
    	   
    	   //�������̽� ��� ������
    	   ActionForward forward=null;
    	   Action action=null;
    	   
    	   // ȸ������ ������ ����ڰ� �����͸� �Է��ϸ�
    	   // MemberAddAction.me�� �����͸� �޾Ƽ� ó��
    	   
    	   //���࿡ command�� ���ſ� ���ٸ�
    	   if(command.equals("/member/MemberAddAction.me")) { // ȸ������ ����
    		   // ȸ�����԰� ���õǾ� �ִ� logic(action)�� db����(dao)
    		   action=new BoardAddAction();
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }else if(command.equals("/member/MemberListAction.me")) { // ȸ������ ��ܸ���Ʈ
    		   action=new MemberListAction();
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }
    	   
    	   if(forward!=null) {
    		   if(forward.isRedirect()) {
    			   // 1. redirect : ���ο� ������������ request, response��ü�� ���Ӱ� �����ȴ�. - �α���,ȸ������,�۾���
    			   response.sendRedirect(forward.getPath());
    		   }else {
    			   //2. dispatcher(forward) : ���� �������� �������� forward�� ���� ȣ��� �������� request, response ��ü�� ����. ����Ʈ����, �˻�
    			   RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
    			   dispatcher.forward(request, response);
    		   }
    	   }
       }
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
