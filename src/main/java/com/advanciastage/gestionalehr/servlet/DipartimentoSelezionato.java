package com.advanciastage.gestionalehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.DepartmentDTO;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.repository.DepartmentRepository;

import com.advanciastage.gestionalehr.repository.GeneralRepository;

/**
 * Servlet implementation class DipartimentoSelezionato
 */
@WebServlet("/dipartimentoselezionato")
public class DipartimentoSelezionato extends HttpServlet {
	private static final long serialVersionUID = 1L;
      DepartmentRepository depRepo = new DepartmentRepository();
      GeneralRepository genRepo = new GeneralRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DipartimentoSelezionato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Long id = Long.parseLong(request.getParameter("dipartimento"));
		DepartmentDTO dto =depRepo.findDepartment(id);
		List<EmployeeDTO> empList=genRepo.cercaEmpInDep(id);
		request.setAttribute("dip",dto);
		request.setAttribute("emp", empList);
		request.getRequestDispatcher("/JSP/dipartimentoselezionato.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
