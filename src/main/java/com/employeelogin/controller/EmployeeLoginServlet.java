package com.employeelogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeelogin.bean.EmployeeLoginBean;
import com.employeelogin.database.EmployeeLoginDao;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/register")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeLoginDao empDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        empDao = new EmployeeLoginDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeLoginBean empBean = new EmployeeLoginBean();
		empBean.setUsername(request.getParameter("username"));
		empBean.setPassword(request.getParameter("password"));
		
		if(empDao.validate(empBean)) {
			response.getWriter().append("Employee Validation Successful.\nData of all the employees.\n");
			response.sendRedirect(request.getContextPath()+"/success");
		} else {
			response.getWriter().append("Sorry, Employee validation failed.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
