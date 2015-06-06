package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IGoodsDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Goods;



public class GoodsDaoImpl implements IGoodsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public GoodsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Goods Goods) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		String fname = Goods.getFname();
		String expplace = Goods.getExpplace();
		String kind = Goods.getKind();
		double price = Goods.getPrice();
		int number = Goods.getNumber();
		int grade = Goods.getGrade();
		
		String strSQL = "insert into Goods values(null,?,?,?,?,?,?)";
		Object[] params = new Object[] { fname,expplace,kind,price,number,grade };
		
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if (affectedRows > 0) {
			// 提交事务
			TransactionManager.commit();
		} else {
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Goods> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Goods> lstGoods = new ArrayList<Goods>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from Goods order by Goodsid";
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
						new Object[] {});
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Customers对象
						Goods Goods = new Goods();
						Goods.setGoodsid(resultSet.getInt(1));
						Goods.setFname(resultSet.getString(2));
						Goods.setExpplace(resultSet.getString(3));
						Goods.setKind(resultSet.getString(4));
						Goods.setPrice(resultSet.getFloat(5));
						Goods.setNumber(resultSet.getInt(6));
						Goods.setGrade(resultSet.getInt(7));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstGoods.add(Goods);
					}
					// 返回结果
					return lstGoods;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 步骤6：关闭数据库连接
					this.connectionManager.closeConnection(conn);
				}

	}

	@Override
	public int deleteById(int Goodsid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 步骤3：创建SQL语句模板
				String strSQL = "delete from Goods where Goodsid=?";
				Object[] params = new Object[] { Goodsid };
				// 步骤4：调用dbutils中的方法完成对数据库的删除操作
				int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
				// 步骤5：根据步骤4的操作结果提交或回滚事务
				if (affectedRwos > 0) {
					TransactionManager.commit(); // 事务提交
				} else {
					TransactionManager.rollback(); // 事务的回滚
				}
				// 步骤6：返回影响行数
				return affectedRwos;		
		
	}

	@Override
	public Goods selectById(int Goodsid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select * from Goods where Goodsid=?";
				Object[] params = new Object[] { Goodsid };
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					if (resultSet.next()) {
						// 步骤6：创建一个Customers对象
						Goods Goods = new Goods();
						Goods.setGoodsid(resultSet.getInt(1));
						Goods.setFname(resultSet.getString(2));
						Goods.setExpplace(resultSet.getString(3));
						Goods.setKind(resultSet.getString(4));
						Goods.setPrice(resultSet.getFloat(5));
						Goods.setNumber(resultSet.getInt(6));
						Goods.setGrade(resultSet.getInt(7));
						
						// 步骤7：返回对象
						return Goods;
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
	public List<Goods> selectByFname(String fname) {
		// TODO Auto-generated method stub
		List<Goods> lstGoods = new ArrayList<Goods>();
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from Goods where fname like ?";
		fname="%"+fname+"%";
		Object[] params = new Object[] { fname };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Goods Goods = new Goods();
				Goods.setGoodsid(resultSet.getInt(1));
				Goods.setFname(resultSet.getString(2));
				Goods.setExpplace(resultSet.getString(3));
				Goods.setKind(resultSet.getString(4));
				Goods.setPrice(resultSet.getFloat(5));
				Goods.setNumber(resultSet.getInt(6));
				Goods.setGrade(resultSet.getInt(7));
				lstGoods.add(Goods);
				// 步骤7：返回对象
			}
				return lstGoods;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}

	@Override
	public int update(Goods Goods) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 步骤3：创建SQL语句模板
				String strSQL = "update Goods set fname=?, expplace=?, kind=?, price=?, number=? ,grade=? where Goodsid=?";
				Object[] params = new Object[] { Goods.getFname(),Goods.getExpplace(),Goods.getKind(),Goods.getPrice(),Goods.getNumber(),Goods.getGrade(),Goods.getGoodsid() };
				// 步骤4：调用dbutils中的方法完成对数据库的删除操作
				int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
				// 步骤5：根据步骤4的操作结果提交或回滚事务
				if (affectedRwos > 0) {
					TransactionManager.commit(); // 事务提交
				} else {
					TransactionManager.rollback(); // 事务的回滚
				}
				// 步骤6：返回影响行数
				return affectedRwos;
			}
	public List<Goods> selectBykind(String kind)
	{
		// TODO Auto-generated method stub
				List<Goods> lstGoods = new ArrayList<Goods>();
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select * from Goods where kind like ?";
				kind="%"+kind+"%";
				Object[] params = new Object[] { kind };
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					while (resultSet.next()) {
						// 步骤6：创建一个Customers对象
						Goods Goods = new Goods();
						Goods.setGoodsid(resultSet.getInt(1));
						Goods.setFname(resultSet.getString(2));
						Goods.setExpplace(resultSet.getString(3));
						Goods.setKind(resultSet.getString(4));
						Goods.setPrice(resultSet.getFloat(5));
						Goods.setNumber(resultSet.getInt(6));
						Goods.setGrade(resultSet.getInt(7));
						lstGoods.add(Goods);
						// 步骤7：返回对象
					}
						return lstGoods;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}
		
	}
	public int[] countAll(){
		// TODO Auto-generated method stub
		List<Goods> lstGoods = new ArrayList<Goods>();
		int[] countlst = new int[1000] ;
		int count=0;
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from Goods ";
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Goods Goods = new Goods();
				Goods.setGoodsid(resultSet.getInt(1));
				Goods.setFname(resultSet.getString(2));
				Goods.setExpplace(resultSet.getString(3));
				Goods.setKind(resultSet.getString(4));
				Goods.setPrice(resultSet.getFloat(5));
				Goods.setNumber(resultSet.getInt(6));
				Goods.setGrade(resultSet.getInt(7));
				lstGoods.add(Goods);
				count++;
				countlst[count] = Goods.getGoodsid();
				// 步骤7：返回对象
			}
			countlst[0] = count;
				return countlst;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	
	}
	

}
