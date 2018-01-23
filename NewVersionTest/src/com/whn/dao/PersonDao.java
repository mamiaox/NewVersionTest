package com.whn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.whn.DBConnection.DBConnection;
import com.whn.domain.Person;

/**
 * 持久层
 *
 * @author user
 */
public class PersonDao {

	/**
	 * 新增人员
	 *
	 * @param p
	 */
	public void add(Person p) {
		// 创建数据库连接
		Connection conn = DBConnection.createConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into person (name,idnumber,sex,birth,marrage,matename) values (?,?,?,?,?,?)";
		try {
			// 创建执行SQL的prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getIdnumber());
			pstmt.setString(3, p.getSex());
			pstmt.setString(4, p.getBirth());
			pstmt.setString(5, p.getMarrage());
			pstmt.setString(6, p.getMatename());
			// 获取result结果集
			int result = pstmt.executeUpdate();
			System.out.println("成功执行：" + result + "条语句");
		} catch (Exception e) {
			System.out.println("出现异常:" + e.toString());
		} finally {
			try {
				if (pstmt != null) {
					// 关闭 Statement对象
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						// 关闭数据库连接,释放资源
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void update(Person p) {
		// 创建数据库连接
		System.out.println("进入了update方法");
		System.out.println(p.getId());
		Connection conn = DBConnection.createConnection();
		PreparedStatement pstmt = null;
		// String sql = "update person set name='" + p.getName() + "',idnumber='" + p.getIdnumber() + "',sex='"
		// + p.getSex() + "',birth='" + p.getBirth() + "',marrage='" + p.getMarrage() + "',matename='"
		// + p.getMatename() + "' where id='" + p.getId() + "'";
		String sql = "update person set name=?,idnumber=?,sex=?,birth=?,marrage=?,matename=? where id='" + p.getId()
				+ "'";
		try {
			// 创建执行SQL的prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getIdnumber());
			pstmt.setString(3, p.getSex());
			pstmt.setString(4, p.getBirth());
			pstmt.setString(5, p.getMarrage());
			pstmt.setString(6, p.getMatename());
			// 获取result结果集
			int result = pstmt.executeUpdate();
			System.out.println("成功执行：" + result + "条语句");
		} catch (Exception e) {
			System.out.println("出现异常:" + e.toString());
		} finally {
			try {
				if (pstmt != null) {
					// 关闭 Statement对象
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						// 关闭数据库连接,释放资源
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<Person> show() {
		// 创建数据库连接
		Connection conn = DBConnection.createConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from person";
		ArrayList<Person> aList = new ArrayList<Person>();
		try {
			// 创建执行SQL的prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			// 数据库响应的查询结果存放在ResultSet类
			ResultSet rs = pstmt.executeQuery();
			// 控制台输出
			// int col = rs.getMetaData().getColumnCount();
			// System.out.println("============================");
			// for (int i = 1; i <= col; i++) {
			// System.out.print(rs.getString(i) + "\t");
			// }
			// System.out.println("");
			// }
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String idnumber = rs.getString(3);
				String sex = rs.getString(4);
				String birth = rs.getString(5);
				String marrage = rs.getString(6);
				String matename = rs.getString(7);
				Person p = new Person();
				p.setId(id);
				p.setName(name);
				p.setIdnumber(idnumber);
				p.setSex(sex);
				p.setBirth(birth);
				p.setMarrage(marrage);
				p.setMatename(matename);
				// 封装对象到集合
				aList.add(p);
			}
			return aList;
		} catch (Exception e) {
			System.out.println("出现异常:" + e.toString());
		} finally {
			try {
				if (pstmt != null) {
					// 关闭 Statement对象
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						// 关闭数据库连接,释放资源
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return aList;
	}

	public void delete(Person p) {
		// 创建数据库连接
		Connection conn = DBConnection.createConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from person where id='" + p.getId() + "'";
		try {
			// 创建执行SQL的prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			// 数据库响应的查询结果存放在ResultSet类
			int result = pstmt.executeUpdate();
			System.out.println("成功执行：" + result + "条语句");
		} catch (Exception e) {
			System.out.println("出现异常:" + e.toString());
		} finally {
			try {
				if (pstmt != null) {
					// 关闭 Statement对象
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						// 关闭数据库连接,释放资源
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
