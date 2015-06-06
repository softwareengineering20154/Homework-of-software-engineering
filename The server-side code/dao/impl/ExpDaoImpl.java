package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IExpDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Exp;
import com.active.cate.vo.Showthoughts;

public class ExpDaoImpl implements IExpDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	private Connection conn;
	
	public ExpDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	@Override
	public List<Showthoughts> selectAll() {
		// TODO Auto-generated method stub
		String strSQL = "select * from showthoughts order by expid desc";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		List<Showthoughts> lstExps = new ArrayList<Showthoughts>();
		try {
			while(resultSet.next()){
				Showthoughts thought = new Showthoughts();
				thought.setExpid(resultSet.getInt(1));
				
				thought.setUserid(resultSet.getInt(2));
				thought.setExpplace(resultSet.getString(3));
				thought.setFoodname(resultSet.getString(4));
				thought.setSatify(resultSet.getString(5));
				thought.setThoughts(resultSet.getString(6));
				thought.setNickname(resultSet.getString(7));
				
				
				lstExps.add(thought);
			}
			return lstExps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	@Override
	public int insert(Exp exp) {
		// TODO Auto-generated method stub

		int foodid = 1;
		int userid = 1;
		String satify = exp.getSatify();
		String expplace = exp.getExpplace();
		String foodname = exp.getFoodname();
		String thoughts = exp.getThoughts();
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		String strSQL = "insert into foodmes values(null, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{foodid,userid,expplace,foodname,satify,thoughts};
		
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectedRows >  0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		
		return affectedRows;
	}
	public static void main(String[] args) {
		
		IExpDao expDao = new ExpDaoImpl();
		List<Showthoughts>lstexps = expDao.selectAll();
		for (Showthoughts thought : lstexps){
			System.out.println(thought.toString());
		}
		
		
		
	}

	@Override
	public List<Exp> selectall() {
		// TODO Auto-generated method stub
		String strSQL = "select * from foodmes order by expid desc";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		List<Exp> lstExp = new ArrayList<Exp>();
		try {
			while(resultSet.next()){
				Exp exp = new Exp();
				exp.setExpid(resultSet.getInt(1));
				exp.setFoodid(resultSet.getInt(2));
				exp.setUserid(resultSet.getInt(3));
				exp.setExpplace(resultSet.getString(4));
				exp.setFoodname(resultSet.getString(5));
				exp.setSatify(resultSet.getString(6));
				exp.setThoughts(resultSet.getString(7));
				lstExp.add(exp);
			}
			return lstExp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public List<Showthoughts> selectById(int userid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				List<Showthoughts> lstexp = new ArrayList<Showthoughts>();
				String strSQL = "select * from showthoughts where userid >= ?";
				Object[] params = new Object[] { userid };
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					while (resultSet.next()) {
						// 步骤6：创建一个Customers对象
						Showthoughts thought = new Showthoughts();
						thought.setExpid(resultSet.getInt(1));
						thought.setUserid(resultSet.getInt(2));
						thought.setExpplace(resultSet.getString(3));
						thought.setFoodname(resultSet.getString(4));
						thought.setSatify(resultSet.getString(5));
						thought.setThoughts(resultSet.getString(6));
						thought.setNickname(resultSet.getString(7));
						lstexp.add(thought);
						System.out.println(thought.toString());
						
						// 步骤7：返回对象
						
						
					}
					return lstexp;
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}

	}

}
