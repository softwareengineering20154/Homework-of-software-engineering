package com.active.school.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.active.school.biz.ISelectFindBiz;
import com.active.school.biz.impl.SelectFindBizImpl;
import com.active.school.po.Users;

/**
 * Servlet implementation class FindUsersByIdServlet
 */
@WebServlet("/FindUsersByIdServlet")
public class FindUsersByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUsersByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		ISelectFindBiz selectFindBiz = new SelectFindBizImpl();
		Users user = selectFindBiz.selectUserbyId(userid);
		request.setAttribute("user", user);
		// 请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/information.jsp");
		dispatcher.forward(request, response);
	}

}
