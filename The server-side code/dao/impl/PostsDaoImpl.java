package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IPostsDao;
import com.active.cate.db.DBUtils;
import com.active.cate.db.TransactionManager;
import com.active.cate.po.Posts;
import com.active.cate.vo.Showposts;
import com.active.cate.db.ConnectionManager;

public class PostsDaoImpl implements IPostsDao {

	private DBUtils dbutils;
	private ConnectionManager connectionManager;
	private Connection conn;

	public PostsDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.connectionManager = new ConnectionManager();
		this.dbutils = new DBUtils();
	}

	// -----------------------------------------------------------------------------------------
	@Override
	public int insert(Posts post) {
		// TODO Auto-generated method stub
		// 数据库连接和事务管理器
		this.conn = connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 拆分对象属性
		System.out.println("yes");
		int userid = post.getUserid();
		int reid = post.getReid();

		String pcontext = post.getPcontext();

		int followid = post.getFollowid();
		// 设置sql模板
		String strSQL = "insert into posts values(null,?,?,?,now(),?)";
		Object[] params = new Object[] { userid, reid, pcontext, followid };
		// 使用dbutils方法
		int affectedRows = this.dbutils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {

			TransactionManager.commit();

		} else {
			TransactionManager.rollback();

		}

		return affectedRows;
	}

	// ------------------------------------------------------------
	@Override
	public List<Showposts> selectByFollowid(int followid) {
		// TODO Auto-generated method stub

		// 步骤1：创建一个空的集合准备存放查询的结果

		List<Showposts> lstPosts = new ArrayList<Showposts>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from showposts where followid =? order by pid desc";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL,
				new Object[] { followid });
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				Showposts post = new Showposts();

				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setNickname(resultSet.getString(5));
				post.setPtime(resultSet.getDate(6));
				post.setFollowid(resultSet.getInt(7));
				lstPosts.add(post);

			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);

		}

	}

	// ---------------------------------------------------------------------------

	@Override
	public int deleteById(int pid) {
		// TODO Auto-generated method stub
		this.conn = connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from posts where pid = ?";
		Object[] params = new Object[] { pid };
		int affectedRows = this.dbutils.execOthers(conn, strSQL, params);
		if (affectedRows > 0)

		{
			TransactionManager.commit();
		} else {

			TransactionManager.rollback();

		}

		return affectedRows;
	}

	@Override
	public Posts selectById(int pid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from posts where pid=?";
		Object[] params = new Object[] { pid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Posts post = new Posts();
				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setPtime(resultSet.getDate(5));
				post.setFollowid(resultSet.getInt(6));
				// 步骤7：返回对象
				return post;
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
	public int update(Posts post) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update posts set pcontext=?,ptime=?,followid=? where pid=?";
		Object[] params = new Object[] { post.getPcontext(), post.getPtime(),
				post.getFollowid(), post.getPid() };
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
	public List<Showposts> selectByNickname(String nickname) {
		// TODO Auto-generated method stub

		List<Showposts> lstPosts = new ArrayList<Showposts>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from showposts where nickname like ? order by pid desc";
		nickname = "%" + nickname + "%";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL,
				new Object[] { nickname });
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				Showposts post = new Showposts();

				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setNickname(resultSet.getString(5));
				post.setPtime(resultSet.getDate(6));
				post.setFollowid(resultSet.getInt(7));
				lstPosts.add(post);

			}
			return lstPosts;
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
	public List<Showposts> selectByPcontext(String pcontext) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果

		List<Showposts> lstPosts = new ArrayList<Showposts>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from showposts where pcontext like ? order by pid desc";
		pcontext = "%" + pcontext + "%";

		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL,
				new Object[] { pcontext });
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				Showposts post = new Showposts();

				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setNickname(resultSet.getString(5));
				post.setPtime(resultSet.getDate(6));
				post.setFollowid(resultSet.getInt(7));
				lstPosts.add(post);

			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);

		}

	}

	public List<Showposts> limitSelect(final int startRow, final int pageSize) {
		List<Showposts> lstPosts = new ArrayList<Showposts>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "SELECT * FROM showposts limit ?,? ";

		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL,
				new Object[] { startRow, pageSize });
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				Showposts post = new Showposts();

				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setNickname(resultSet.getString(5));
				post.setPtime(resultSet.getDate(6));
				post.setFollowid(resultSet.getInt(7));
				lstPosts.add(post);

			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);

		}

	}
	public int selectAll(){
		
		List<Showposts> lstPosts = new ArrayList<Showposts>();
		int count = 0;
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "SELECT * FROM showposts ";

		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				count++;
				Showposts post = new Showposts();

				post.setPid(resultSet.getInt(1));
				post.setUserid(resultSet.getInt(2));
				post.setReid(resultSet.getInt(3));
				post.setPcontext(resultSet.getString(4));
				post.setNickname(resultSet.getString(5));
				post.setPtime(resultSet.getDate(6));
				post.setFollowid(resultSet.getInt(7));
				lstPosts.add(post);

			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);

		}
	}

}
