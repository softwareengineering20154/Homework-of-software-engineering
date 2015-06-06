package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.ICollectPostsDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Collectposts;
import com.active.cate.vo.Showcollectposts;


public class CollectPostsDaoImpl implements ICollectPostsDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	Connection conn;
	public CollectPostsDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	
	

	@Override
	public int insert(Collectposts collectpost) {
		// TODO Auto-generated method stub
		
		int userid = collectpost.getUserid();
		int pid = collectpost.getPid();
		
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		String strSQL = "insert into collectposts values(null, ?, ?)";
		Object[] params = new Object[]{userid,pid};
		
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectedRows >  0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		
		return affectedRows;
	}



	@Override
	public int delete(int userid, int pid) {
		// TODO Auto-generated method stub
		this.conn = connectionManager.openConnection();
		TransactionManager.conn= this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete  from collectposts where userid = ? and pid = ?" ;
		Object [] params = new Object []{userid,pid};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		 if (affectedRows>0)
			 
		 {
			 TransactionManager.commit();
		 }else {
			 
		
		TransactionManager.rollback();
		
		 }
		 return affectedRows;
	}



	@Override
	public List<Showcollectposts> selectAll(int userid) {
		// TODO Auto-generated method stub
	//步骤1：创建一个空的集合准备存放查询的结果
		
		List<Showcollectposts> lstCollectposts = new ArrayList<Showcollectposts>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		//步骤3：创建查询语句的模板
		String strSQL = "select * from showcollectposts where userid = ? order by collectpostid desc";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{userid});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next())
			{
				Showcollectposts collectposts = new Showcollectposts();
				collectposts.setCollectpostid(resultSet.getInt(1));
				collectposts.setUserid(resultSet.getInt(2));
				collectposts.setPid(resultSet.getInt(3));
				collectposts.setNickname(resultSet.getString(4));
				collectposts.setPcontext(resultSet.getString(5));
				lstCollectposts.add(collectposts);
				
				
				
				
				
}
			return lstCollectposts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
			
			
		}
	}



	

}
