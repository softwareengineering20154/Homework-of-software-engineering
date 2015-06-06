package com.active.school.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.active.school.biz.ILimitSelectBiz;
import com.active.school.biz.impl.LimitSelectBizImpl;
import com.active.school.vo.Page;
import com.active.school.vo.Showposts;

/**
 * Servlet implementation class LimitedShowServlet
 */
@WebServlet("/LimitedShowServlet")
public class LimitedShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimitedShowServlet() {
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
		ILimitSelectBiz limitSelectBiz = new LimitSelectBizImpl();
		int totalCount = limitSelectBiz.selectAll();
		Page page = new Page();
		List<Showposts> lstPosts = new ArrayList<Showposts>();
		/**
		 * 在这里设置页号
		 * 这里先获得jsp页面传来的页面请求信息
		 */
		int pageNumber;
		try {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			page.setPageNumber(pageNumber);
			page.setTotalCount(totalCount);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lstPosts = limitSelectBiz.limitSelect(page.getStartRow(), page.getPageSize());
		
		request.setAttribute("lstPosts", lstPosts);
		request.setAttribute("totalPage", page.getTotalPage());
		request.setAttribute("pageNumber", page.getPageNumber());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/limit.jsp");
		 dispatcher.forward(request, response);
	}

}
