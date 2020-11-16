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
    	   
    	   //인터페이스 없어서 빨간색
    	   ActionForward forward=null;
    	   Action action=null;
    	   
    	   // 회원가입 폼에서 사용자가 데이터를 입력하면
    	   // MemberAddAction.me로 데이터를 받아서 처리
    	   
    	   //만약에 command가 저거와 같다면
    	   if(command.equals("/MemberAddAction.me")) { // 회원가입 쓰기
    		   // 회원가입과 관련되어 있는 logic(action)과 db연동(dao)
    		   action=new BoardAddAction();
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }// MemberAddAction.me끝
    	   else if(command.equals("/MemberListAction.me")) { // 회원가입 명단리스트
    		   action=new MemberListAction();
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }// MemberListAction.me 끝
    	   else if(command.equals("/MemberDetailAction.me")) {// MemberDetailAction.me시작
    		   // 회원의 상세내용페이지와 관련되어 있는 logic(action)과 db연동(dao)
    		   action=new MemberDetailAction();// 상세페이지 조회
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }// MemberDetailAction.me끝
    	   else if(command.equals("/MemberModifyAction.me")) {// MemberModifyAction.me시작
    		  
    		   // 회원의 상세내용페이지와 관련되어 있는 logic(action)과 db연동(dao)
    		   action=new MemberModifyAction();// 상세페이지 조회
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }// MemberModifyAction.me끝
    	   else if(command.equals("/MemberDelAction.me")) {// MemberModifyAction.me시작
    		  
    		   // 회원의 상세내용페이지와 관련되어 있는 logic(action)과 db연동(dao)
    		   action=new MemberDelAction();// 상세페이지 조회
    		   try {
    			   forward=action.execute(request, response);
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }// MemberModifyAction.me끝
    	   
    	   
    	   if(forward!=null) {
    		   if(forward.isRedirect()) {
    			   // 1. redirect : 새로운 페이지에서는 request, response객체가 새롭게 생성된다. - 로그인,회원가입,글쓰기
    			   response.sendRedirect(forward.getPath());
    		   }else {
    			   //2. dispatcher(forward) : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request, response 객체를 공유. 리스트보기, 검색
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
