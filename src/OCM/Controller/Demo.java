package OCM.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OCM.Model.*;
import OCM.Data.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo() {
        // TODO: Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>This is a test servlet.</h1>"); */
		
		response.setContentType("text/plain");
		
		String str = request.getParameter("name"); // could be "email" and/or "password".
		request.setAttribute("name", str);
		request.setAttribute("blah", "aaa");
		
		ArrayList<User> arr = null;
		
		try {
			arr = UserData.getAllUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("data", arr);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Views/TestServlet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: Auto-generated method stub
		doGet(request, response);
	}

}
