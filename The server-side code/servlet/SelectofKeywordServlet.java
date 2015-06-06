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

import com.active.school.biz.ISelectFindBiz;
import com.active.school.biz.IShowpostsByContextBiz;
import com.active.school.biz.IShowpostsByNicknameBiz;
import com.active.school.biz.impl.SelectFindBizImpl;
import com.active.school.biz.impl.ShowpostsByNicknameBizImpl;
import com.active.school.biz.impl.ShowpostsByPcontext;
import com.active.school.po.Goods;
import com.active.school.po.Users;
import com.active.school.vo.Showposts;

/**
 * Servlet implementation class SelectFindServlet
 */
@WebServlet("/SelectFindServlet")
public class SelectFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectFindServlet() {
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
		request.setCharacterEncoding("UTF-8");
		ISelectFindBiz selcetFindBiz = new SelectFindBizImpl();
		String account = request.getParameter("country");// 第一个下拉菜单
		int i = Integer.parseInt(account);
		System.out.println(i);
		String password = request.getParameter("city");// 第二个
		int j = Integer.parseInt(password);
		System.out.println(password);
		String select = request.getParameter("select");
		System.out.println(select);
		
				//String name = select;
				//String value = account;
	            Cookie c = new Cookie(select, account);//搜索内容
	            c.setMaxAge(10*60);
	            System.out.println(c.getValue());
	            response.addCookie(c);
	        
		
		if (i == 11) {// school
			List<Goods> lstGoods = new ArrayList<Goods>();
			if (j == 21)// name
			{

				lstGoods = selcetFindBiz.selectGoodsbyName(select);

			} else// j==22 kind
			{
				lstGoods = selcetFindBiz.selectGoodsbyKind(select);
			}

			for (Goods goods : lstGoods) {
				System.out.println("wrong");
				goods.toString();
			}
			 request.setAttribute("lstGoods", lstGoods);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showResult.jsp");
			 dispatcher.forward(request, response);
		} else {
			if (i == 12)// post
			{
				List<Showposts> lstPosts = new ArrayList<Showposts>();
				if (j == 21)// theme
				{
					IShowpostsByContextBiz showpostsByPcontext = new ShowpostsByPcontext();
					lstPosts = showpostsByPcontext.findByPcontext(select);

				} else// j==22 user who send
				{
					IShowpostsByNicknameBiz showpostsByNicknameBiz = new ShowpostsByNicknameBizImpl();
					lstPosts = showpostsByNicknameBiz.findByNickname(select);

				}
				for (Showposts goods : lstPosts) {
					System.out.println("wrong");
					goods.toString();
				}
				request.setAttribute("lstPosts", lstPosts);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showResult.jsp");
				 dispatcher.forward(request, response);
			} else// i==13 user
			{
				List<Users> lstUsers = new ArrayList<Users>();
				if (j == 21)// nickname
				{
					lstUsers = selcetFindBiz.selectUserbyName(select);
				} else// j=22 college
				{
					lstUsers = selcetFindBiz.selectUserbyCol(select);
				}
				for (Users users : lstUsers) {
					System.out.println(users.toString());
				}
				 request.setAttribute("lstUsers", lstUsers);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showResult.jsp");
				 dispatcher.forward(request, response);
			}
		}
	}
	// 步骤3：将获取的数据添加到request级别对象中
	// request.setAttribute("lstCustomers", lstCustomers);
	// 步骤4：使用请求转发模式完成界面的跳转（可以携带reuqest对象进行跳转）
	// RequestDispatcher dispatcher =
	// request.getRequestDispatcher("jsp/showResult.jsp");
	// dispatcher.forward(request, response);
}
