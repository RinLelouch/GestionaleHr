package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.repository.JobRepository;
import com.advanciastage.gestionalehr.service.Service;

/**
 * Servlet implementation class ModificaSalario
 */
@WebServlet("/modificasalario")
public class ModificaSalario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new Service();
	private JobRepository jobRepo = new JobRepository();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaSalario() {
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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String jobId = (String) request.getParameter("jobId");
		String min = request.getParameter("nuovoMinimo");
		String max = request.getParameter("nuovoMassimo");
		Long minL = 0l;
		Long maxL = 0l;
		session.setAttribute("jobId", jobId);
		Employee emp = (Employee) session.getAttribute("emp");
		if(emp.getJobId().equals(jobId)) {
			session.setAttribute("errorMessage",
					"non puoi modificare il salario di questo lavoro , essendo il tuo, FURBETTO!");
			response.sendRedirect("aggiornamentosalari");
		}
		else {

		if (!min.isBlank() || !min.isEmpty()) {
			minL = Long.parseLong(min);
		}
		if (!max.isBlank() || !max.isEmpty()) {
			maxL = Long.parseLong(max);
		}

		if (service.numbPercentageMax(maxL, jobId) || service.numbPercentageMin(minL, jobId) || maxL == 0 || minL == 0) {
			if (service.numbPercentageMax(maxL, jobId) || maxL == 0) {
				if (service.numbPercentageMin(minL, jobId) || minL == 0) {
					jobRepo.updateSalary(minL, maxL, jobId);
					response.sendRedirect("salarioaggiornato");
				} else {

					session.setAttribute("errorMessage",
							"il salario Minimo indicato supera la riduzione dello stipendio attuale del 10%");
					response.sendRedirect("aggiornamentosalari");
				}
			} else {

				session.setAttribute("errorMessage",
						"il salario Massimo indicato supera l'aumento dello stipendio attuale del 10%");
				response.sendRedirect("aggiornamentosalari");
			}
		}else {
			session.setAttribute("errorMessage",
					"entrambi i valori  indicati superano l'aumento e la riduzione dello stipendio attuale del 10%");
			response.sendRedirect("aggiornamentosalari");
		}
		
	}
		}

}
