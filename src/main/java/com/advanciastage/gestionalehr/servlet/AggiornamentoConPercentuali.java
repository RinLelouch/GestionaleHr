package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.repository.JobRepository;

/**
 * Servlet implementation class AggiornamentoConPercentuali
 */
@WebServlet("/aggiornamentoconpercentuali")
public class AggiornamentoConPercentuali extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobRepository jobRepo= new JobRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiornamentoConPercentuali() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jobId= request.getParameter("jobId");
		String aumentoMax=request.getParameter("aumentoMassimoPercentuale");
		
		String aumentoMin= request.getParameter("aumentoMinimoPercentuale");
		
		Double maxA=0.0;
		
		Double minA=0.0;
		
		Job job = jobRepo.selectJobById(jobId);
		if(!aumentoMax.isBlank() || !aumentoMax.isEmpty()) {
			maxA=Double.parseDouble(aumentoMax);
			
		} 
		if(!aumentoMin.isBlank() || !aumentoMin.isEmpty()) {
			minA=Double.parseDouble(aumentoMin);
		}
		
		Long maxSalary = job.getMaxSalary();
		Long minSalary = job.getMinSalary();
		Long conversionMax= (long) (maxSalary/maxA);
		Long conversionMin= (long) (minSalary/minA);
		jobRepo.updateSalary(conversionMin, conversionMax, jobId);
		response.sendRedirect("salarioaggiornato");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
