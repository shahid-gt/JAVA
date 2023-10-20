package com.employeelogin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeelogin.database.EmployeeLoginDao;
import com.employeelogin.bean.EmployeeLoginBean;

/**
 * Servlet implementation class LoginSuccessServlet
 */
@WebServlet("/success")
public class LoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeLoginDao empDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSuccessServlet() {
		super();
		// TODO Auto-generated constructor stub
		empDao = new EmployeeLoginDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		EmployeeLoginBean[] empBeans = empDao.listEmployees();
		for (EmployeeLoginBean empBean : empBeans) {
			output.println("\n========================\n");
			output.println(empBean.getUsername());
			output.println(empBean.getPassword());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
