package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Department;
import com.advanciastage.gestionalehr.repository.DepartmentRepository;

/**
 * Servlet implementation class InserisciDipendenteDispatcher
 */
@WebServlet("/inseriscidipendente")
public class InserisciDipendenteDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DepartmentRepository depRepo= new DepartmentRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciDipendenteDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Boolean alto= (Boolean) session.getAttribute("ALTO");
		if(alto !=null && alto) {
			List<Department> listaDep= depRepo.selectAllDepartmentsManagerNotNull();
			request.setAttribute("listaDep",listaDep);
		}
		request.getRequestDispatcher("/JSP/insertutente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
