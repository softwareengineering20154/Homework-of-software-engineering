package com.active.school.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.active.cate.dao.IFriendsDao;
import com.active.cate.db.ConnectionManager;
import com.active.cate.db.DBUtils;
import com.active.cate.vo.Friends;

public class FriendsDaoImpl implements IFriendsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	

	public FriendsDaoImpl() {
		super();
		
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}



	@Override
	public List<Friends> selectFriends(int userid) {
		// TODO Auto-generated method stub
		//步骤1：创建一个空的集合准备存放查询的结果
		
				List<Friends> lstFriends = new ArrayList<Friends>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				//步骤3：创建查询语句的模板
				String strSQL = "select * from friends where userid =? order by relationshipid desc";
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{userid});
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next())
					{
						Friends friends = new Friends();
						
						friends.setRelationshipid(resultSet.getInt(1));
						friends.setUserid(resultSet.getInt(2));
						friends.setFriendid(resultSet.getInt(3));
						friends.setNickname(resultSet.getString(4));
						friends.setFnickname(resultSet.getString(5));
						friends.setCollege(resultSet.getString(6));
						friends.setGender(resultSet.getString(7));
						lstFriends.add(friends);
						
					}
					return lstFriends;
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
	
	public static void main(String[] args) {
		int userid = 1;
		
		IFriendsDao friendsDao = new FriendsDaoImpl();
		List<Friends> lstfriends = friendsDao.selectFriends(userid);
		
		for (Friends friends :lstfriends){
			System.out.println(friends.toString());
		}
		
	}
}


