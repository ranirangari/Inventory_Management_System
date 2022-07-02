package com.inventory.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.inventory.model.Category;
import com.inventory.services.CategoryServices;


@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String page = request.getParameter("page");

		switch (page) {
			
		case "addCategory":
			addCategory(request,response);
			break;
			
		case "allCategory":
			allCategory(request,response);
			break;
			
		case "deleteCategory":
			deleteCategory(request,response);
			break;
			
		case "updateCategory":
			updateCategory(request,response);
			break;
			
			
			
		default:
			break;
		}
	}
	
		
		private void addCategory(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			Category category=new Category();
			category.setItemCategory(request.getParameter("itemCategory"));
			
			boolean status = CategoryServices.saveCategory(category);

			if (status) {
				request.getRequestDispatcher("addcategory.jsp").forward(request, response);	
			}else{
				request.setAttribute("msg", "Something went wrong !");
				request.getRequestDispatcher("home.jsp").forward(request, response);	

		}
	}
	
		private void allCategory(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			List<Category> allCategory = CategoryServices.getAllCategory();
			System.out.println("All Category" + allCategory);
			request.setAttribute("allCategory", allCategory);
			request.getRequestDispatcher("all_category.jsp").forward(request, response);
		}

		private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			Category category = new Category();
			category.setId(Integer.parseInt(request.getParameter("id")));
			boolean status = CategoryServices.deleteCategory(category);
			if (status) {
				List<Category> allCategory = CategoryServices.getAllCategory();
				System.out.println("All Category" + allCategory);
				request.setAttribute("allCategory", allCategory);
				request.getRequestDispatcher("all_category.jsp").forward(request, response);
			}
		}

		private void updateCategory(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Category category = new Category();
			category.setId(Integer.parseInt(request.getParameter("id")));
			category.setItemCategory(request.getParameter("itemCategory"));

			// System.out.println(itemBean);
			boolean status = CategoryServices.updateCategory(category);
			if (status) {
				List<Category> allCategory = CategoryServices.getAllCategory();
				request.setAttribute("allCategory", allCategory);
				request.getRequestDispatcher("all_category.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Something went wrong !");
				request.getRequestDispatcher("updatecategory.jsp").forward(request, response);

			}
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

