package com.active.school.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.active.school.biz.IRegisterBiz;
import com.active.school.biz.impl.RegisterBizImpl;
import com.active.school.po.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤1：设置请求数据字符集
		request.setCharacterEncoding("UTF-8");
		System.out.println("ok");
		// --------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String user_data = request.getParameter("user_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		Users user = gson.fromJson(user_data, Users.class);

		// 步骤4：调用Biz业务逻辑层的add方法完成新客户的添加操作
		IRegisterBiz registerBiz = new RegisterBizImpl();
		boolean flag = registerBiz.register(user);
		String flaga = flag == true ? "ok" : "fuck";
		// 步骤6：响应客户端
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String gson_data = gson.toJson(flaga);

		System.out.println(gson_data);
		out.println(gson_data);

		out.flush();
		out.close();
	}

}
