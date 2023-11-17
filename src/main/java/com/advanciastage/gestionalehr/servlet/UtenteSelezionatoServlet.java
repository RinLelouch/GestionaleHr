package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.repository.EmployeeRepository;
import com.mysql.cj.util.StringUtils;

/**
 * Servlet implementation class UtenteSelezionatoServlet
 */
@WebServlet("/utenteselezionato")
public class UtenteSelezionatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeRepository empRepo = new EmployeeRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtenteSelezionatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String id = request.getParameter("id_dipendente");
		String idD =request.getParameter("id_dipartimento");
		if(!StringUtils.isNullOrEmpty(id)) {
		Long idEmp = Long.parseLong(id);EmployeeDTO emp = empRepo.findByIdEmployeeDTO(idEmp);
		request.setAttribute("dipendente", emp);
		}
		if(!StringUtils.isNullOrEmpty(idD)) {
		Long idDip=Long.parseLong(idD);
	    EmployeeDTO manager=	empRepo.findManagerByIdDep(idDip);
	    request.setAttribute("manager", manager);
		}
		request.getRequestDispatcher("/JSP/utenteselezionato.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
