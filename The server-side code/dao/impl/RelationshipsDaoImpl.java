package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IRelationshipsDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Relationships;

public class RelationshipsDaoImpl implements IRelationshipsDao {
	private DBUtils dbutils;
	private ConnectionManager connectionManager;
	private Connection conn;
	
	

	public RelationshipsDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.connectionManager = new ConnectionManager();
		this.dbutils = new DBUtils ();
	}

	@Override
	public int insert(Relationships relationship) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//数据库连接和事务管理器
		        System.out.println("yes");
				this.conn =connectionManager.openConnection();
				TransactionManager.conn= this.conn;
				TransactionManager.beginTransaction();
				
				//拆分对象属性
				int userid = relationship.getUserid();
				int friendid = relationship.getFriendid();
				System.out.println(userid);
				System.out.println(friendid);
		
				
				//设置sql模板
				String strSQL = "insert into relationship values(null,?,?)";
				Object []params = new Object []{userid,friendid};
				//使用dbutils方法
				int affectedRows = this.dbutils.execOthers(conn, strSQL, params);
				System.out.println(affectedRows);
				if (affectedRows > 0){
					
					TransactionManager.commit();
					
				}
				else {
					TransactionManager.rollback();
					
				}
				
				return affectedRows;
	}

	@Override
	public List<Relationships> selectAll() {
		// TODO Auto-generated method stub
	//步骤1：创建一个空的集合准备存放查询的结果
		
		List<Relationships> lstRelationships = new ArrayList<Relationships>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		//步骤3：创建查询语句的模板
		String strSQL = "select * from relationship order by relationshipid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, new Object[]{});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next())
			{
				Relationships relationships = new Relationships();
			    relationships.setRelationshipid(resultSet.getInt(1));
				relationships.setUserid(resultSet.getInt(2));
				relationships.setFriendid(resultSet.getInt(3));
				lstRelationships.add(relationships);
				
				
}
			return lstRelationships;
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
	@Override
	public int deleteById(int userid,int friendid) {
		// TODO Auto-generated method stub
		this.conn = connectionManager.openConnection();
		TransactionManager.conn= this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete  from relationship where userid = ? and friendid = ?" ;
		Object [] params = new Object []{userid,friendid};
		int affectedRows = this.dbutils.execOthers(conn, strSQL, params);
		 if (affectedRows>0)
			 
		 {
			 TransactionManager.commit();
		 }else {
			 
		
		TransactionManager.rollback();
		
		 }
		
		
		
		return affectedRows;
	}

	@Override
	public Relationships selectById(int relationshipid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from relationship where relationshipid=?";
		Object[] params = new Object[] { relationshipid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Relationships relationship = new Relationships();
				relationship.setRelationshipid(resultSet.getInt(1));
				relationship.setUserid(resultSet.getInt(2));
				relationship.setFriendid(resultSet.getInt(3));
				
				// 步骤7：返回对象
				return relationship;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}

	@Override
	public int update (Relationships relationship) {
		// TODO Auto-generated method stub
				// 步骤1：获取一个数据库连接对象
						this.conn = this.connectionManager.openConnection();
						// 步骤2：开启事务
						TransactionManager.conn = this.conn;
						TransactionManager.beginTransaction();
						// 步骤3：创建SQL语句模板
						String strSQL = "update relationship set userid=?,friendid =?, where relationshipid=?";
						Object[] params = new Object[] { relationship.getUserid(),relationship.getFriendid(),relationship.getRelationshipid()};
						// 步骤4：调用dbutils中的方法完成对数据库的删除操作
						int affectedRows = this.dbutils.execOthers(conn, strSQL, params);
						// 步骤5：根据步骤4的操作结果提交或回滚事务
						if (affectedRows > 0) {
							TransactionManager.commit(); // 事务提交
						} else {
							TransactionManager.rollback(); // 事务的回滚
						}
						// 步骤6：返回影响行数
						return affectedRows;
		
	}

	@Override
	public Relationships selectByObject(int userid, int friendid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select * from relationship where userid=? and friendid = ? ";
				Object[] params = new Object[] { userid , friendid};
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					if (resultSet.next()) {
						// 步骤6：创建一个Customers对象
						Relationships relationship = new Relationships();
					
						relationship.setUserid(resultSet.getInt(1));
						relationship.setFriendid(resultSet.getInt(2));
						
						// 步骤7：返回对象
						return relationship;
					} else {
						return null;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}

}
}

