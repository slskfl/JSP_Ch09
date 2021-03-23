package com.ezen.dao;

import java.sql.Connection;
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
	
}
