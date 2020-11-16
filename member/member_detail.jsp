<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.member.db.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// MemberDetailAction에서 select한 저장한 값 객체화 시키기
	MemberBean member = (MemberBean)request.getAttribute("memberdetail"); // 오브젝트타입으로 넘어오게 된다. 형변환을 해주어야한다.
	System.out.println("member_detail.jsp="+member);
%>
</head>
<body>
	<form action="MemberModifyAction.me" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=member.getId()%>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" value="<%=member.getPw()%>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"
					value="<%=member.getName()%>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="text" name="gender" value="<%=member.getGender() %>"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="회원정보수정">
				</td>
				<td>
					<a href="MemberDelAction.me?id=<%=member.getId()%>">탈퇴</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>