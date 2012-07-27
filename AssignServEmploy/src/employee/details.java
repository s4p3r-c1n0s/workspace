package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class details
 */
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DOA doa = DOA.getObject();
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("header");
		rd.include(request, response);
		PrintWriter pw = response.getWriter();
		try {
			String[] details = doa.fetchDetails(request.getParameter("name"));
			if(details!=null){
				pw.println("<br>Name : "+details[0]);
				pw.println("<br>Designation : "+details[1]);
				pw.println("<br>Phone No : "+details[2]);
				pw.println("<br>Address : "+details[3]);
			}
			else pw.println("No EMPLOYEE named "+request.getParameter("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
