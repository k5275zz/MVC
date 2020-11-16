<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼</h1>
<form action="../MemberAddAction.me" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td>비밀번호재확인</td>
			<td><input type="password"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="m">남<input type="radio" name="gender" value="w">여</td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
	</table>
</form>

</body>
</html>
