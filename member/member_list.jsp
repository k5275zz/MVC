<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.member.db.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
//ArrayList<MemberBean>
	ArrayList<MemberBean> boardList= (ArrayList<MemberBean>)request.getAttribute("memberlist");
	System.out.println(boardList);
%>

</head>
<body>
<h1>member_list페이지</h1>
<table border="1">
	<tr>
		<td colspan="4">회원명단리스트</td>
	</tr>
	<tr>
		<td>아이디</td><td>비밀번호</td><td>이름</td><td>성별</td>
	</tr>
	<!-- for 시작 -->
	<%for(int i=0;i<boardList.size();i++){
		MemberBean member=(MemberBean)boardList.get(i);
	%>
	<tr>
		<td><%=member.getId() %></td>
		<td><%=member.getPw() %></td>
		<td><%=member.getName() %></td>
		<td><%=member.getGender() %></td>
	</tr>
	<%} %>
	<!-- for 종료 -->
</table>
</body>
</html>
