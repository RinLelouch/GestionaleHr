package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.repository.DepartmentRepository;

/**
 * Servlet implementation class ConfermaInsertimentoNuovoDipendente
 */
@WebServlet("/riepilogoinserimento")
public class ConfermaInsertimentoNuovoDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfermaInsertimentoNuovoDipendente() {
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
		HttpSession session = request.getSession(false);
		String job = request.getParameter("job");
		if (!job.isEmpty()) {

			String name = (String) session.getAttribute("insertName");
			String cognome = (String) session.getAttribute("insertCognome");
			String phone = (String) session.getAttribute("insertNumero");
			String depName=(String) session.getAttribute("insertDepName");
		    Long managerId= (Long) session.getAttribute("insertManagerId");
		    session.setAttribute("insertJobId", job);
		    request.setAttribute("name", name);
		    request.setAttribute("cognome", cognome);
		    request.setAttribute("depName", depName);
		    request.setAttribute("phone", phone);
		    request.setAttribute("managerId", managerId);
		    request.setAttribute("job", job);
			request.getRequestDispatcher("/JSP/riepilogoinserimento.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "devi selezionare un lavoro per poter proseguire");
			request.getRequestDispatcher("/JSP/sceltajob.jsp").forward(request, response);
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
