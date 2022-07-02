
package com.inventory.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.inventory.model.Category;
import com.inventory.model.ItemBean;
import com.inventory.services.CategoryServices;
import com.inventory.services.ItemServices;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String page = request.getParameter("page");

		switch (page) {

		case "addItem":
			addItem(request, response);
			break;

		case "allItem":
			allItem(request, response);
			break;

		case "deleteItem":
			deleteItem(request, response);
			break;

		case "updateItem":
			updateItem(request, response);
			break;

		case "gotoaddItem":
			gotoaddItem(request, response);
			break;

		default:
			break;
		}
	}

	private void gotoaddItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> allCategory = CategoryServices.getAllCategory();
		request.setAttribute("allCategory", allCategory);
		request.getRequestDispatcher("additem.jsp").forward(request, response);

	}

	private void addItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // TODO Auto-generated method stub

		ItemBean itemBean = new ItemBean();
		String pStart = "Rs";
		String pEnd = ".00";
		String price = request.getParameter("itemPrice");
		price = price.concat(pEnd);
		pStart = pStart.concat(price);
		System.out.println(pStart);

		itemBean.setItemCode(request.getParameter("itemCode"));
		itemBean.setItemName(request.getParameter("itemName"));
		itemBean.setItemBrand(request.getParameter("itemBrand"));
		itemBean.setItemCategory(request.getParameter("itemCategory"));
		itemBean.setItemDescription(request.getParameter("itemDescription"));
		itemBean.setItemQuantity(request.getParameter("itemQuantity"));
		itemBean.setItemPrice(Float.parseFloat(request.getParameter("itemPrice")));

		boolean status = ItemServices.saveItem(itemBean);

		if (status) {
			request.getRequestDispatcher("additem.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Something went wrong !");
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
	}

	private void allItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ItemBean> allItem = ItemServices.getAllItem();
		System.out.println("All Items" + allItem);
		request.setAttribute("allItem", allItem);
		request.getRequestDispatcher("all_item.jsp").forward(request, response);
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ItemBean itemBean = new ItemBean();
		itemBean.setId(Integer.parseInt(request.getParameter("id")));
		boolean status = ItemServices.deleteItem(itemBean);
		if (status) {
			List<ItemBean> allItem = ItemServices.getAllItem();
			System.out.println("All Items" + allItem);
			request.setAttribute("allItem", allItem);
			request.getRequestDispatcher("all_item.jsp").forward(request, response);
		}
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemBean itemBean = new ItemBean();
		itemBean.setId(Integer.parseInt(request.getParameter("id")));
		itemBean.setItemCode(request.getParameter("itemCode"));
		itemBean.setItemName(request.getParameter("itemName"));
		itemBean.setItemBrand(request.getParameter("itemBrand"));
		itemBean.setItemCategory(request.getParameter("itemCategory"));
		itemBean.setItemDescription(request.getParameter("itemDescription"));
		itemBean.setItemQuantity(request.getParameter("itemQuantity"));
		itemBean.setItemPrice(Float.parseFloat(request.getParameter("itemPrice")));

		// System.out.println(itemBean);
		boolean status = ItemServices.updateItem(itemBean);
		if (status) {
			List<ItemBean> allItem = ItemServices.getAllItem();
			request.setAttribute("allItem", allItem);
			request.getRequestDispatcher("all_item.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Something went wrong !");
			request.getRequestDispatcher("updateitem.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
