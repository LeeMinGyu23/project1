package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response); 
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//회원인증을 위한 서블릿 클래스 만들기
		String url="member/login.jsp";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberDAO mDao=MemberDAO.getInstance();
		int result=mDao.userCheck(id, pwd);
		
		if(result==1) {
			MemberVO mVO=mDao.getMember(id);
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", mVO);
			request.setAttribute("message", "회원가입이 성공했습니다.");
			url="main.jsp";
		}else if(result == 0){
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else {
			request.setAttribute("message", "존재하지 않은 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); 
	}

}
