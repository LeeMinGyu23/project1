<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../script/member.js"></script>
		<link rel="stylesheet" type="text/css" href="css/2.css" />
	</head>
	
	<body>
	<div class="content">
		<div class="content_form">		
			<form method="post" action="login.do" name="frm" class="form">
				<h3 class="title" style="margin-top:20px;"><a href="main.jsp">Anthony Mlller</a></h3>
				
				<table>
					<tr>
						<th class="length">아이디 : </th>
						<td><input type="text" name="id" value="${id}"/></td>
					</tr>
					
					<tr>
						<th class="length">암 &nbsp; 호 : </th>
						<td><input type="password" name="pwd" /></td>
					</tr>
				</table>
				<p style="margin-top:20px;">
					<input type="submit" value="로그인" onclick="return loginCheck();" />  <br/>
					<br/>
					<input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 찾기  &nbsp; &nbsp;&nbsp;|" onclick="location.href='join.do'" />
					<input type="button" value="아이디 찾기&nbsp; &nbsp; &nbsp;|" onclick="location.href='join.do'" />
					<input type="button" value="회원가입" onclick="location.href='join.do'" />
				</p>
				
				<p style="margin-top:20px; text-align:center;">
					<span style="color:red">${message} </span>
				</p>
			</form>
		</div>
	</div>	
	</body>
</html>