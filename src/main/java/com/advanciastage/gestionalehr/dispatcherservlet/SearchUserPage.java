package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Department;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.entity.Location;
import com.advanciastage.gestionalehr.repository.GeneralRepository;

/**
 * Servlet implementation class SearchUserPage
 */
@WebServlet("/searchuserpage")
public class SearchUserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GeneralRepository generalRepo = new GeneralRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Department> departments=generalRepo.selectAllDepartments();
		List<Job> jobs=generalRepo.selectAllJobs();
		List<Location> locations=generalRepo.selectAllLocations();
		request.setAttribute("departments", departments);
		request.setAttribute("locations", locations);
		request.setAttribute("jobs", jobs);
		session.setAttribute("departments", departments);
		session.setAttribute("locations", locations);
		session.setAttribute("jobs", jobs);
		
		request.getRequestDispatcher("/JSP/ricercadipendenti.jsp").forward(request, response);
		
	}

}
