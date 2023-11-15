package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.advanciastage.gestionalehr.entity.Department;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.entity.Location;
import com.advanciastage.gestionalehr.repository.GeneralRepository;

/**
 * Servlet implementation class SearchUsers
 */
@WebServlet("/searchusers")
public class SearchUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GeneralRepository generalRepo = new GeneralRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUsers() {
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
		Long id =0l;
		if(!request.getParameter("id").isEmpty() || !request.getParameter("id").isBlank() ) {
		id = Long.parseLong(request.getParameter("id"));
		}
		String name = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String nomeDipartimento = request.getParameter("nomeDipartimento");
		String localita = request.getParameter("località");
		String jobTitle = request.getParameter("jobTitle");
		List<EmployeeDTO> listaRicercati=  generalRepo.selectGeneric(id, name, cognome, email, nomeDipartimento, localita, jobTitle);
		request.setAttribute("listaRicercati", listaRicercati);
		request.getRequestDispatcher("/JSP/listadipendenti.jsp").forward(request, response);
	}

}
