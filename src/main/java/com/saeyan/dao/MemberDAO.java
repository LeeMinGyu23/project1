package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

//데이터베이스 테이블과 연동해서 작업하는 데이터베이스 처리를 위한 DAO클래스 생성
public class MemberDAO {
	
	//매개변수없는 생성자 생성
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance=new MemberDAO();// 객체생성
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//컨넥션을 얻어오는 메소드 추가
	public Connection getConnection() throws Exception{
		Connection conn=null;
		Context initContext = new InitialContext();  //네이밍 조작을 위한 클래스 객체생성
		Context envContext  = (Context)initContext.lookup("java:/comp/env"); //지정한 이름 찾기
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");  //지정한 이름 찾기
		conn = ds.getConnection(); 
		return conn;
	}
	
	//사용자 인증시 사용되는 메소드 생성
	public int userCheck(String id, String pwd) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//일치하면 1 일치하지않으면 -1
		int result=-1;
		String sql="select * from member where id=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {   //패스워드가 빈공간이면 안되고 동일한 패스워드인지 물어보는거
				if(rs.getString("pwd") != null && pwd.equals(rs.getString("pwd"))) {
					result=1;
				}else {
					result=0;
				}
				
			}else {
				result=-1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String id) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		MemberVO mVO=null;
		String sql="select * from member where id=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mVO=new MemberVO();
				mVO.setId(rs.getString("id"));
				mVO.setPwd(rs.getString("pwd"));
				mVO.setName(rs.getString("name"));
				mVO.setPhone(rs.getString("phone"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mVO;
	}
	
	
	//아이디 중복 체크를 위한 메소드 추가하기
	public int confirmID(String id) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int result=-1;  //중복아이디이면 1, 그렇지 아니하면 -1
		String sql="select id from member where id=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result; 
		
	}
	
	//회원 정보를 db에 추가하기 위한 메소드 추가하기
	public int insertMember(MemberVO mVO) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int result=-1;
		String sql="insert into member values(?,?,?,?)";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPwd());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getPhone());
			
			//select는 query insert는 update
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	//회원정보 변경하기 위한 메소드 생성하기
	public int updateMember(MemberVO mVO) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int result = -1;
		String sql="update member set pwd=?, name=?, phone=? where id=?";
		
		try {
			
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getPwd());
			pstmt.setString(2, mVO.getName());
			pstmt.setString(3, mVO.getPhone());
			pstmt.setString(4, mVO.getId());
			
			result=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { //rs는 select 할때만 나온다
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;	
	}
	
}
























