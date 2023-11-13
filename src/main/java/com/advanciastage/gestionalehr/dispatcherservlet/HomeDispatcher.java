package com.advanciastage.gestionalehr.dispatcherservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advanciastage.gestionalehr.entity.Employee;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class HomeDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Employee emp=(Employee) session.getAttribute("emp");
		Boolean admin =(Boolean) session.getAttribute("ALTO");
		Boolean manager =(Boolean) session.getAttribute("MEDIO");
		Boolean dipendente =(Boolean) session.getAttribute("BASSO");
		request.setAttribute("employee", emp);
		request.setAttribute("ALTO", admin);
		request.setAttribute("MEDIO", manager);
		request.setAttribute("BASSO", dipendente);
		request.getRequestDispatcher("/JSP/loginsuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
