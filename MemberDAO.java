package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {

	public MemberDAO() {
		
	}
	
	//싱글톤 패턴
	private static MemberDAO instance =new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//DB 연결하기
	public Connection getConnectoin() throws Exception{
		Connection conn=null;
		Context initContext=new InitialContext();
		Context envContext
			=(Context)initContext.lookup("java:/comp/env");
		DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");
		conn=ds.getConnection();
		return conn;
	}
	
	//result가 1이면 아이디 중복, -1일 경우 아이디 사용 가능
	public int confirmID(String userid) {
		int result=-1;
		String sql="select userid from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnectoin();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=1; //아이디 사용 중
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
