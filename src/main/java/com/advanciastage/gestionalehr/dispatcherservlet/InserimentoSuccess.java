package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.repository.EmployeeRepository;
import com.advanciastage.gestionalehr.repository.JobRepository;

/**
 * Servlet implementation class InserimentoSuccess
 */
@WebServlet("/dipendenteinserito")
public class InserimentoSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobRepository jobRepo= new JobRepository();
	private EmployeeRepository empRepo= new EmployeeRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(false);
		String name = (String) session.getAttribute("insertName");
		String cognome = (String) session.getAttribute("insertCognome");
		String phone = (String) session.getAttribute("insertNumero");
		String depName=(String) session.getAttribute("insertDepName");
	    Long managerId= (Long) session.getAttribute("insertManagerId");
	    String job=(String) session.getAttribute("insertJobId");
	    Long depId= (Long) session.getAttribute("insertIdDipartimento");
		Long salary= jobRepo.getMinSalary(job);
		empRepo.insertEmployee(name, cognome, phone, depId, managerId, job, salary);
		request.getRequestDispatcher("/JSP/inserimentosuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
