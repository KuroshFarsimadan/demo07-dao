package ir.kuroshfarsimadan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.kuroshfarsimadan.demo07.bean.Person;
import ir.kuroshfarsimadan.demo07.dao.PersonDAO;


/**
 * Servlet implementation class HenkiloServlet
 */
@WebServlet("/persons")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the persons from the database
		PersonDAO pDao = new PersonDAO();
		List<Person> persons  = pDao.retrieveAll();
		
		// Store the requests 
		request.setAttribute("persons", persons);
		
		// JSP will take care of the format jsp hoitaa muotoilun
		request.getRequestDispatcher("persons.jsp").forward(request, response);
		
	}

}
