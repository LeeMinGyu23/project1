<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Project1</title>
		<link rel="stylesheet" type="text/css" href="css/1.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	</head>
	
	<body>
		<header style="min-width:1400px;">
 			<div class=af>
	 			<h1 class="logo"><a href=""><img src="img/world_wildlife_fund_logo_2372.gif" alt="판다"/></a><span class="font">&nbsp; Anthony Mlller</span></h1>
	 		
	 			<nav>
	 				<ul>
		 				<li><a href="">Home</a></li>
		 				<li><a href="">Training</a></li>
		 				<li><a href="">About</a></li>
		 				<li><a href="">Testimonials</a></li>
		 				<li><a href="">FAQ</a></li>
		 				<li><a href="">Contact</a></li>
		 				<li class="text">
		 					<%if(session.getAttribute("loginUser")==null){%>
		 						<a href="login.do"><span class="material-symbols-outlined icon">Login</span><em>Login In</em></a>
		 				<% 	}else{ %>
		 						<form method="post" action="logout.do" class="logout">
		 							<input type="submit" value="Log out">
		 						</form>	
		 					<% } %>
		 				
		 				</li>
			 			<li><a href=""><img src="img/jpg1.png" alt="페이스북"/></a></li>
			 			<li><a href=""><img src="img/jpg2.png" alt="인스타그램"/></a></li>
			 			<li><a href=""><img src="img/jpg3.png" alt="유튜브"/></a></li>
	 				</ul>
	
	 			</nav>
	 		</div>	
 	</header>
	</body>
</html>