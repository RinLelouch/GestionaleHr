package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.repository.EmployeeRepository;

/**
 * Servlet implementation class SearchButton
 */
@WebServlet("/search")
public class SearchButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeRepository empRepo = new EmployeeRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchButton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchOption = request.getParameter("search");
		
		List<Employee> emp = new ArrayList<>();
				if("all".equals(searchOption)) {
					emp=empRepo.selectAllEmployee();
				} else if("managers".equals(searchOption)) {
					emp=empRepo.selectAllManagers();
				} else if("dipendenti".equals(searchOption)) {
					emp=empRepo.selectOnlyEmployee();
				}
			request.setAttribute("listaRicercati", emp);
			request.getRequestDispatcher("/JSP/searchbybutton.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
