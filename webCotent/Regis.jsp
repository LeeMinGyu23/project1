<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" type="text/css" href="css/3.css" />
	</head>
	<body>
		
		<section>
		<div class="content">
			<div class="content_form">	
			<form method="post" action="RegisResult.jsp" class="form">
			<h3 class="title" style="margin-top:20px; margin-left:-100%;">회원정보를 입력해주세요.</h3>
				
				<table>
					<tr>
						<th><label for="userid">아이디</label></th>
						<td><input type="text" name="id" id="userid" value="${id}"></td>
					</tr>
					
					<tr>
						<th><label for="userpwd">비밀번호</label></th>
						<td><input type="password" name="pwd" id="userpwd"></td>
					</tr>
					
					<tr>
						<th><label for="userpwd2">비밀번호확인</label></th>
						<td><input type="password" name="pwd2" id="userpwd2"></td>
					</tr>
					
					<tr>
						<th><label for="username">이름</label></th>
						<td><input type="text" name="name" id="username"></td>
					</tr>
					
					<tr>
						<th><label for="userphone">전화번호</label></th>
						<td><input type="text" name="phone" id="userphone"></td>
					</tr>
				</table>
				<p">
					<input type="submit" value="가입하기">
				</p>
			</form>
			</div>
		</div>
		</section>
	</body>
</html>