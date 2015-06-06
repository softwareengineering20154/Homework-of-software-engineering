package com.active.school.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.active.cate.po.Food;

/**
 * Servlet implementation class SelectCookie
 */
@WebServlet("/SelectCookie")
public class SelectCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCookie() {
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
		request.setCharacterEncoding("UTF-8");
		List<String> lstCookies = new ArrayList<String>();
		Cookie[] cookies=request.getCookies();
		 for(int i=0;i<cookies.length;i++)
		 {
		  if(cookies[i].getName().length()<10)
		  {
		   //得到cookie中的属性值
		   String value=cookies[i].getName();
		   System.out.println("cookies.value="+value);
		   lstCookies.add(value);
		  }
		 }
		 String a = "    a   a";
		 request.setAttribute("ifc", a);
		 request.setAttribute("lstCookies", lstCookies);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/select.jsp");
		 dispatcher.forward(request, response);
	}

}
