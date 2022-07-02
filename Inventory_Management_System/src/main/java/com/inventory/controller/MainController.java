package com.inventory.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.inventory.model.UserBean;
import com.inventory.services.UserServices;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("page");

		switch (page) {

		case "register":
			userregister(request, response);
			break;

		case "login":
			userLogin(request, response);
			break;

		case "addUser":
			addUser(request, response);
			break;

		case "allUser":
			allUser(request, response);
			break;

		case "deleteUser":
			deleteUser(request, response);
			break;

		case "updateUser":
			updateUser(request, response);
			break;

		case "logout":
			userLogout(request, response);
			break;
			
		default:
			break;
		}
	}

	
	private void userregister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ubean = new UserBean();
		ubean.setFname(request.getParameter("fname"));
		ubean.setMname(request.getParameter("mname"));
		ubean.setLname(request.getParameter("lname"));
		ubean.setEmail(request.getParameter("email"));
		ubean.setMobile(request.getParameter("mobile"));
		ubean.setAddress(request.getParameter("address"));
		ubean.setPassword(request.getParameter("password"));

		boolean status = UserServices.saveUser(ubean);
		if (status) {

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ubean = new UserBean();
		ubean.setFname(request.getParameter("fname"));
		ubean.setMname(request.getParameter("mname"));
		ubean.setLname(request.getParameter("lname"));
		ubean.setEmail(request.getParameter("email"));
		ubean.setMobile(request.getParameter("mobile"));
		ubean.setAddress(request.getParameter("address"));
		ubean.setPassword(request.getParameter("password"));

		boolean status = UserServices.saveUser(ubean);

		if (status) {
			request.getRequestDispatcher("adduser.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		UserBean ubean = new UserBean();
		ubean.setEmail(request.getParameter("username"));
		ubean.setPassword(request.getParameter("password"));

		ubean = UserServices.loginUser(ubean);

		boolean status = ubean.isStatus();

		if (status) {
			session.setAttribute("fname", ubean.getFname());
			session.setAttribute("email", ubean.getEmail());
			session.setAttribute("user", ubean);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Email or Password is incorrect!");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

	@SuppressWarnings("unused")
	private void userLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean ubean = new UserBean();

		
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.invalidate();
		request.setAttribute("msg", "logout successfully");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void allUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<UserBean> allUser = UserServices.getAllUser();
		System.out.println("All Users" + allUser);
		request.setAttribute("allUser", allUser);
		request.getRequestDispatcher("alluser.jsp").forward(request, response);

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean userBean = new UserBean();
		userBean.setId(Integer.parseInt(request.getParameter("id")));
		boolean status = UserServices.deleteUser(userBean);
		if (status) {
			List<UserBean> allUser = UserServices.getAllUser();
			System.out.println("All User" + allUser);
			request.setAttribute("allUser", allUser);
			request.getRequestDispatcher("alluser.jsp").forward(request, response);

		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setId(Integer.parseInt(request.getParameter("id")));
		userBean.setFname(request.getParameter("fname"));
		userBean.setMname(request.getParameter("mname"));
		userBean.setLname(request.getParameter("lname"));
		userBean.setEmail(request.getParameter("email"));
		userBean.setMobile(request.getParameter("mobile"));
		userBean.setAddress(request.getParameter("address"));
		userBean.setPassword(request.getParameter("password"));
		System.out.println(userBean);
		boolean status = UserServices.updateUser(userBean);
		if (status) {
			List<UserBean> allUser = UserServices.getAllUser();
			request.setAttribute("allUser", allUser);
			request.getRequestDispatcher("alluser.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Something went wrong !");
			request.getRequestDispatcher("updateuser.jsp").forward(request, response);

		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
