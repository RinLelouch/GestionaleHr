package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.service.Service;

/**
 * Servlet implementation class SalarioAggiornatoDispatcher
 */
@WebServlet("/salarioaggiornato")
public class SalarioAggiornatoDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new Service();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalarioAggiornatoDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String jobId= (String) session.getAttribute("jobId");
		service.checkSalary(jobId);
		request.getRequestDispatcher("/JSP/salarioaggiornato.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
