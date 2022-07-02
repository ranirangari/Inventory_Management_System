package com.inventory.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.inventory.connection.DAO;
import com.inventory.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CategoryServices {
	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;

	public static boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		

		String sql = "insert into item_category (itemCategory) values (?)";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, category.getItemCategory());

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

	public static List<Category> getAllCategory() {

		String sql = "select * from item_Category";
		List<Category> allCategory = new ArrayList<Category>();

		try {
			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("id"));
				
				category.setItemCategory(rs.getString("itemCategory"));

				allCategory.add(category);
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
		return allCategory;

	}

	public static boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		String sql = "delete from item_category where id=?";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, category.getId());
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

	public static Category getCategory(int id) {
		
		Category category=new Category();
		String sql = "select * from item_category where id=?";

		try {
			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {

				category.setId(rs.getInt("id"));
				category.setItemCategory(rs.getString("itemCategory"));

				return category;
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
		return category;
	}

	public static boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		String sql = "update item_category set itemCategory=? where id=?";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, category.getItemCategory());
			pst.setInt(2, category.getId());

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
