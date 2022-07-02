package com.inventory.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventory.connection.DAO;
import com.inventory.model.UserBean;

public class UserServices {

	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;

	public static boolean saveUser(UserBean ubean) {

		String sql = "insert into employee_data (fname, mname, lname, email, mobile, address, password) values(?,?,?,?,?,?,?)";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, ubean.getFname());
			pst.setString(2, ubean.getMname());
			pst.setString(3, ubean.getLname());
			pst.setString(4, ubean.getEmail());
			pst.setString(5, ubean.getMobile());
			pst.setString(6, ubean.getAddress());
			pst.setString(7, ubean.getPassword());
			int result = pst.executeUpdate();

			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public static UserBean loginUser(UserBean ubean) {
		// TODO Auto-generated method stub
		String sql = "select * from employee_data where email=? and password=?";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, ubean.getEmail());
			pst.setString(2, ubean.getPassword());
			rs = pst.executeQuery();

			if (rs.next()) {
				ubean.setId(Integer.parseInt(rs.getString("id")));
				ubean.setFname(rs.getString("fname"));
				ubean.setMname(rs.getString("mname"));
				ubean.setLname(rs.getString("lname"));
				ubean.setEmail(rs.getString("email"));
				ubean.setMobile(rs.getString("mobile"));
				ubean.setPassword(rs.getString("password"));
				ubean.setStatus(true);

				return ubean;

			} else {
				ubean.setStatus(false);
				return ubean;
			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ubean;

	}

	public static List<UserBean> getAllUser() {

		String sql = "select * from employee_data";
		List<UserBean> allUser = new ArrayList<UserBean>();

		try {
			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				UserBean userBean = new UserBean();

				userBean.setId(rs.getInt("id"));
				userBean.setFname(rs.getString("fname"));
				userBean.setMname(rs.getString("mname"));
				userBean.setLname(rs.getString("lname"));
				userBean.setEmail(rs.getString("email"));
				userBean.setMobile(rs.getString("mobile"));
				userBean.setAddress(rs.getString("address"));
				userBean.setPassword(rs.getString("password"));
				allUser.add(userBean);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allUser;

	}

	public static boolean deleteUser(UserBean userBean) {
		// TODO Auto-generated method stub
		String sql = "delete from employee_data where id=?";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, userBean.getId());
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public static UserBean getUser(int id) {
		
		UserBean user=new UserBean();
		String sql = "select * from employee_data where id=?";

		try {
			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {

				user.setId(rs.getInt("id"));
				user.setFname(rs.getString("fname"));
				user.setMname(rs.getString("mname"));
				user.setLname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;

	}
	
	public static boolean updateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		String sql = "update employee_data set fname=?, mname=?, lname=?, email=?, mobile=?, address=?, password=?  where id=?";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, userBean.getFname());
			pst.setString(2, userBean.getMname());
			pst.setString(3, userBean.getLname());
			pst.setString(4, userBean.getEmail());
			pst.setString(5, userBean.getMobile());
			pst.setString(6, userBean.getAddress());
			pst.setString(7, userBean.getPassword());
			pst.setInt(8, userBean.getId());

			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}
}