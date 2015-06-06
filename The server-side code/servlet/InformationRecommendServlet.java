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

import com.active.school.biz.IRecmmondBiz;
import com.active.school.biz.impl.RecommondBizImpl;
import com.active.school.dao.IGoodsDao;
import com.active.school.dao.impl.GoodsDaoImpl;
import com.active.school.po.Goods;

/**
 * Servlet implementation class recommendServlet
 */
@WebServlet("/recommendServlet")
public class recommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommendServlet() {
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
		
		List<Goods> lstGoodsRandow = new ArrayList<Goods>();
		List<Goods> lstGoodsHot = new ArrayList<Goods>();
		List<Goods> lstGoodsRecommond = new ArrayList<Goods>();
		
		IRecmmondBiz recommondBiz = new RecommondBizImpl();
		
		int[] countlst = recommondBiz.countAll();				
		int C=(int)(Math.random()*(countlst[0]-3));
		Goods foodD = recommondBiz.getGoods(countlst[C]);
		Goods foodA = recommondBiz.getGoods(countlst[C+1]);
		Goods foodB = recommondBiz.getGoods(countlst[C+2]);
		Goods foodC = recommondBiz.getGoods(countlst[C+3]);
		lstGoodsRandow.add(foodA);
		lstGoodsRandow.add(foodB);
		lstGoodsRandow.add(foodC);
		lstGoodsRandow.add(foodD);
		
		//   hot
		IGoodsDao foodDao = new GoodsDaoImpl();
		lstGoodsHot = foodDao.selectAll();
		int max=0;
		for (Goods food : lstGoodsHot) {
			if(food.getNumber()*food.getGrade()>max)
			{
				max = food.getNumber()*food.getGrade();
				foodA = food;
			}
		}
		System.out.println("max="+max);
		//   hot
		//  hard
		
		//  hard
		
		 request.setAttribute("lstGoodsRandow", lstGoodsRandow);
		 request.setAttribute("lstGoodsHot", foodA);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/recommend.jsp");
		 dispatcher.forward(request, response);
	}

}
