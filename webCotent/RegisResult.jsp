<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String uid="movie";
	String pass="1234";
	String sql="insert into member values(?,?,?,?,?)";
%>

<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String pwd2=request.getParameter("pwd2");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,uid,pass);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pwd);
		pstmt.setString(3,pwd2);
		pstmt.setString(4,name);
		pstmt.setString(5,phone);
		
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입성공</title>
		<link rel="stylesheet" type="text/css" href="css/4.css" />
	</head>
	
	<body>
		<div class="content">
			<div class="content_form">	
				<h3>회원가입성공</h3>
				<a href="main.jsp" style="font-size:1.3em;">메인화면으로 돌아가기</a>
			</div>
		</div>
	</body>
</html>