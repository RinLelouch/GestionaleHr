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
import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.repository.DepartmentRepository;
import com.advanciastage.gestionalehr.repository.JobRepository;
import com.advanciastage.gestionalehr.service.Service;

/**
 * Servlet implementation class SceltaLavoro
 */
@WebServlet("/sceltalavoro")
public class SceltaLavoro extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Service service = new Service();
     private JobRepository jobRepo= new JobRepository();
     private DepartmentRepository depRepo= new DepartmentRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SceltaLavoro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String cognome = request.getParameter("cognome");
		String phoneNumb= request.getParameter("phone");
		String dipScelto= request.getParameter("dipartimentoScelto");
		Long idDipartimento=0l;
		Employee manager = (Employee) session.getAttribute("emp");
		if(service.controlloNumeroTelefono(phoneNumb)) {
			if(dipScelto.isEmpty() || dipScelto.isBlank()) {
				idDipartimento= manager.getDepartmentId();
			} else {
				idDipartimento=Long.parseLong(dipScelto);
			}
			Department dep = depRepo.Department(idDipartimento);
			Long managerId= dep.getManagerId();
			String depName= dep.getDepartmentName();
			session.setAttribute("insertDepName", depName);
			session.setAttribute("insertManagerId", managerId);
			session.setAttribute("insertName", name);
			session.setAttribute("insertCognome", cognome);
			session.setAttribute("insertNumero", phoneNumb);
			session.setAttribute("insertIdDipartimento", idDipartimento);
			List<Job> jobs= jobRepo.selectJobsByDepNotManagers(idDipartimento);
			request.setAttribute("jobs", jobs);
			request.getRequestDispatcher("/JSP/sceltajob.jsp").forward(request, response);
			
			
		}else {
			request.setAttribute("errorMessage", "il numero di telefono deve essere composto solo da numeri e punti per delimitare i suddetti, riprovare");
			request.getRequestDispatcher("/JSP/insertutente.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
