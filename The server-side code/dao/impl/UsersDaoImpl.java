package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IUsersDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Users;

public class UsersDaoImpl implements IUsersDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public UsersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Users users) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启一个事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				
			String account = users.getAccount();
			String password = users.getPassword();
			String nickname = users.getNickname();
			String gender = users.getGender();
			String college = users.getCollege();
			int usercondition = users.getUsercondition();
			String context = users.getContext();
			String statement = users.getStatement();
			users.getTime();
				
				String strSQL = "insert into users values(null,?,?,?,?,?,?,?,?,now())";
				Object[] params = new Object[] { account,password,nickname,gender,college,usercondition,context,statement };
				
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
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Users> lstUsers = new ArrayList<Users>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from users order by userid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Users users = new Users();
				users.setUserid(resultSet.getInt(1));
				users.setAccount(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickname(resultSet.getString(4));
				users.setGender(resultSet.getString(5));
				users.setCollege(resultSet.getString(6));
				users.setUsercondition(resultSet.getInt(7));
				users.setContext(resultSet.getString(8));
				users.setStatement(resultSet.getString(9));
				users.setTime(resultSet.getDate(10));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstUsers.add(users);
			}
			// 返回结果
			return lstUsers;
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
	public int deleteById(int userid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from users where userid=?";
		Object[] params = new Object[] { userid };
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
	public Users selectById(int userid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from users where userid=?";
		Object[] params = new Object[] { userid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Users users = new Users();
				users.setUserid(resultSet.getInt(1));
				users.setAccount(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickname(resultSet.getString(4));
				users.setGender(resultSet.getString(5));
				users.setCollege(resultSet.getString(6));
				users.setUsercondition(resultSet.getInt(7));
				users.setContext(resultSet.getString(8));
				users.setStatement(resultSet.getString(9));
				users.setTime(resultSet.getDate(10));
				// 步骤7：返回对象
				return users;
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
	public List<Users> selectByName(String nickname) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from users where nickname like ? ";
		//String strSQL = "select * from users where nickname=? ";
		nickname="%"+nickname+"%";
		Object[] params = new Object[] { nickname };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Users users = new Users();
				users.setUserid(resultSet.getInt(1));
				users.setAccount(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickname(resultSet.getString(4));
				users.setGender(resultSet.getString(5));
				users.setCollege(resultSet.getString(6));
				users.setUsercondition(resultSet.getInt(7));
				users.setContext(resultSet.getString(8));
				users.setStatement(resultSet.getString(9));
				users.setTime(resultSet.getDate(10));
				// 步骤7：返回对象
				System.out.println("UsersDao+1");
				lstUsers.add(users);
			}
				return lstUsers;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int update(Users users) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update users set password=?, nickname=?, gender=?, college=?, usercondition=? ,context=?, statement=? where userid=?";
		Object[] params = new Object[] { users.getPassword(),users.getNickname(),users.getGender(),users.getCollege(),users.getUsercondition(),users.getContext(),users.getStatement(),users.getUserid() };
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
	public Users selectByObject(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from users where account=? and password=?";
		Object[] params = new Object[]{account, password};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
			
				Users users = new Users();
				users.setUserid(resultSet.getInt(1));
				users.setAccount(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickname(resultSet.getString(4));
				users.setGender(resultSet.getString(5));
				users.setCollege(resultSet.getString(6));
				users.setUsercondition(resultSet.getInt(7));
				users.setContext(resultSet.getString(8));
				users.setStatement(resultSet.getString(9));
				users.setTime(resultSet.getDate(10));
				
				return users;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}	
		return null;
	}
	public List<Users> selectByCollege(String college) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from users where college like ?";
		college="%"+college+"%";
		Object[] params = new Object[] { college };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Users users = new Users();
				users.setUserid(resultSet.getInt(1));
				users.setAccount(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickname(resultSet.getString(4));
				users.setGender(resultSet.getString(5));
				users.setCollege(resultSet.getString(6));
				users.setUsercondition(resultSet.getInt(7));
				users.setContext(resultSet.getString(8));
				users.setStatement(resultSet.getString(9));
				users.setTime(resultSet.getDate(10));
				// 步骤7：返回对象
				lstUsers.add(users);
			}
				return lstUsers;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	

}
