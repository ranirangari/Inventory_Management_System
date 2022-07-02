package com.inventory.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.inventory.connection.DAO;
import com.inventory.model.ItemBean;

public class ItemServices {

	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	public static boolean saveItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
		
		String sql = "insert into item_data (itemCode, itemName, itemBrand, itemCategory, itemDescription, itemQuantity, itemPrice) values(?,?,?,?,?,?,?)";
		try {

			con = DAO.getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, itemBean.getItemCode());
			pst.setString(2, itemBean.getItemName());
			pst.setString(3, itemBean.getItemBrand());
			pst.setString(4, itemBean.getItemCategory());
			pst.setString(5, itemBean.getItemDescription());
			pst.setString(6, itemBean.getItemQuantity());
			pst.setFloat(7, itemBean.getItemPrice());

			
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


public static List<ItemBean> getAllItem() {

	String sql = "select * from item_data";
	List<ItemBean> allItem = new ArrayList<ItemBean>();

	try {
		con = DAO.getCon();
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();

		while (rs.next()) {
			ItemBean itemBean = new ItemBean();

			itemBean.setId(rs.getInt("id"));
			itemBean.setItemCode(rs.getString("itemCode"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setItemBrand(rs.getString("itemBrand"));
			itemBean.setItemCategory(rs.getString("itemCategory"));
			itemBean.setItemDescription(rs.getString("itemDescription"));
			itemBean.setItemQuantity(rs.getString("itemQuantity"));
			itemBean.setItemPrice(Float.parseFloat(rs.getString("itemPrice")));
			//itemBean.setActive(Boolean.parseBoolean(rs.getString("isActive")));

			allItem.add(itemBean);
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
	return allItem;

}

public static boolean deleteItem(ItemBean itemBean) {
	// TODO Auto-generated method stub
	String sql = "delete from item_data where id=?";
	try {

		con = DAO.getCon();
		pst = con.prepareStatement(sql);
		pst.setInt(1, itemBean.getId());
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

public static ItemBean getItem(int id) {
	
	ItemBean item=new ItemBean();
	String sql = "select * from item_data where id=?";

	try {
		con = DAO.getCon();
		pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		rs = pst.executeQuery();

		if (rs.next()) {

			item.setId(rs.getInt("id"));
			item.setItemCode(rs.getString("itemCode"));
			item.setItemName(rs.getString("itemName"));
			item.setItemBrand(rs.getString("itemBrand"));
			item.setItemCategory(rs.getString("itemCategory"));
			item.setItemDescription(rs.getString("itemDescription"));
			item.setItemQuantity(rs.getString("itemQuantity"));
			item.setItemPrice(Float.parseFloat(rs.getString("itemPrice")));
			//item.setActive(Boolean.parseBoolean(rs.getString("isActive")));

			return item;
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
	return item;
}

public static boolean updateItem(ItemBean itemBean) {
	// TODO Auto-generated method stub
	String sql = "update item_data set itemCode=?, itemName=?, itemBrand=?, itemCategory=?, itemDescription=?, itemQuantity=?, itemPrice=? where id=?";
	try {

		con = DAO.getCon();
		pst = con.prepareStatement(sql);
		pst.setString(1, itemBean.getItemCode());
		pst.setString(2, itemBean.getItemName());
		pst.setString(3, itemBean.getItemBrand());
		pst.setString(4, itemBean.getItemCategory());
		pst.setString(5, itemBean.getItemDescription());
		pst.setString(6, itemBean.getItemQuantity());
		pst.setFloat(7, itemBean.getItemPrice());
		//pst.setBoolean(8, itemBean.isActive());
		pst.setInt(8, itemBean.getId());

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