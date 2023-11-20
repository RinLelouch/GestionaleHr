package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.entity.Percentuale;
import com.advanciastage.gestionalehr.entity.Percentuali;
import com.advanciastage.gestionalehr.repository.GeneralRepository;
import com.advanciastage.gestionalehr.repository.JobRepository;

/**
 * Servlet implementation class GestioneSalariDIspatcher
 */
@WebServlet("/aggiornamentosalari")
public class GestioneSalariDIspatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneralRepository generalRepo= new GeneralRepository();
	private JobRepository jobRepo= new JobRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneSalariDIspatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Boolean alto = (Boolean) session.getAttribute("ALTO");
		Boolean medio = (Boolean) session.getAttribute("MEDIO");
		String error= (String) session.getAttribute("errorMessage");
		List<Job> jobs = new ArrayList<>();
		if(alto !=null && alto) {
			jobs=generalRepo.selectAllJobs();
			request.setAttribute("ALTO", true);
		}else if(medio != null && medio) {
			Employee emp=(Employee) session.getAttribute("emp");
			Long depId = emp.getDepartmentId();
			jobs=jobRepo.selectJobsByManager(depId);
		}
		Percentuali perc= new Percentuali();
		List<Percentuale> percentuali= perc.getLista();
		request.setAttribute("percentuali", percentuali);
		request.setAttribute("errorMessage", error);
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("JSP/aggiornasalari.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
