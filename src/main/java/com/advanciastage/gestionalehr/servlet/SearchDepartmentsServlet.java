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
import com.advanciastage.gestionalehr.repository.DepartmentRepository;
import com.mysql.cj.util.StringUtils;

/**
 * Servlet implementation class SearchDepartmentsServlet
 */
@WebServlet("/searchdepartments")
public class SearchDepartmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DepartmentRepository depRepo = new DepartmentRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDepartmentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String idString= request.getParameter("id");
		String idLocString = request.getParameter("località");
		Long id= StringUtils.isNullOrEmpty(idString) ? 0L : Long.parseLong(idString);
		Long idLocalita= StringUtils.isNullOrEmpty(idLocString) ? 0L : Long.parseLong(idLocString);
		String dipartimento = request.getParameter("nomeDipartimento");
		
		
		List<DepartmentDTO> departmentsResult=depRepo.departmentSearchDinamic(id, dipartimento, idLocalita);
		request.setAttribute("departmentsResult", departmentsResult);
		request.getRequestDispatcher("/JSP/listadipartimenti.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
