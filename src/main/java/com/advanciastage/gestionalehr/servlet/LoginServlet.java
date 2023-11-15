package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.repository.EmployeeRepository;
import com.advanciastage.gestionalehr.repository.RegionRepository;
import com.advanciastage.gestionalehr.service.Service;

/**
 * Servlet implementation class ProvaServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeRepository employeeRepo = new EmployeeRepository();
	private Service service = new Service();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegionRepository regRepo = new RegionRepository();
		regRepo.findById(1);
		regRepo.findAll();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Employee emp = (Employee) employeeRepo.findByEmail(email);
		if (emp != null && emp instanceof Employee) {
			
			if (service.checkLogin(emp, password)) {

				request.setAttribute("employee", emp);
				request.setAttribute("autorizzato", true);
				session.setAttribute("autorizzato", true);
				session.setAttribute("employee", emp);

				if (service.checkStatus(emp) == 1) {
					request.setAttribute("ALTO", true);
					session.setAttribute("ALTO", true);
					request.getRequestDispatcher("Home").forward(request, response);

				} else if (service.checkStatus(emp) == 2) {
					request.setAttribute("MEDIO", true);
					session.setAttribute("MEDIO", true);
					request.getRequestDispatcher("Home").forward(request, response);

				} else {
					request.setAttribute("BASSO", true);
					session.setAttribute("BASSO", true);
					request.getRequestDispatcher("Home").forward(request, response);
				}

			} else {
				session.setAttribute("failToLogin", "password sbagliata, riprovare.");
				request.getRequestDispatcher("Login").forward(request, response);
			}
		} else {
			session.setAttribute("failToLogin", " email sbagliata, riprovare.");
			request.getRequestDispatcher("Login").forward(request, response);
		}

	}

}
