package com.ezen.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//페이지 이동
		String path="member/join.jsp";
		RequestDispatcher dispatcher
			=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	/** * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 System.out.println("doPost() 호출");
		
	}

}
