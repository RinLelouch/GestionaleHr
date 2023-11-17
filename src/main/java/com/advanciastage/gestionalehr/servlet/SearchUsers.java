package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		Long empId = (Long) session.getAttribute("empId");
		String name = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String nomeDipartimento = request.getParameter("nomeDipartimento");
		String localita = request.getParameter("località");
		String jobTitle = request.getParameter("jobTitle");
		String data = request.getParameter("data");
		String formattedDate= "";
		if(!data.isEmpty() || !data.isBlank()) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(data, inputFormatter);
	    LocalDateTime localDateTime = localDate.atStartOfDay();
	    

	    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	     formattedDate = localDateTime.format(outputFormatter);
	    }
		List<EmployeeDTO> listaRicercati=  generalRepo.selectGeneric(id, name, cognome, email, nomeDipartimento, localita, jobTitle,formattedDate);
		List<EmployeeDTO> listaPerDipartimento = generalRepo.selectGenericByManager(empId, id, name, cognome, email, jobTitle, formattedDate);
		request.setAttribute("listaRicercati", listaRicercati);
		request.setAttribute("listaDipartimentoManager", listaPerDipartimento);
		request.getRequestDispatcher("/JSP/listadipendenti.jsp").forward(request, response);
	}

}
