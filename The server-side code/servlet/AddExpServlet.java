package com.active.school.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.active.school.biz.IExpBiz;
import com.active.school.biz.impl.ExpBizImpl;
import com.active.school.po.Exp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AddExpServlet
 */
public class AddExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddExpServlet() {
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
		// 步骤1：设置字符编码集合
		request.setCharacterEncoding("UTF-8");
		// 步骤2：接受客户端传入的数据
		// --------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String experience_data = request.getParameter("experience_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		Exp exp = gson.fromJson(experience_data, Exp.class);

		System.out.println(exp.toString());

		// 步骤4：调用Biz层业务实现回复动作
		IExpBiz addExpBiz = new ExpBizImpl();
		boolean flag = addExpBiz.addExp(exp);
		// 步骤5：根据动作结果响应客户端

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String gson_data = gson.toJson(flag);

		System.out.println(gson_data);
		out.println(gson_data);

		out.flush();
		out.close();
	}

}
