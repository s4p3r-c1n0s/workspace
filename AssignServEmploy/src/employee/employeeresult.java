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
 * Servlet implementation class employeeresult
 */
public class employeeresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DOA doa = DOA.getObject();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("header");
		rd.include(request, response);
		String name = request.getParameter("name");
		String search = request.getParameter("search");
		try {
			String []result = doa.fetchEmployee(name,search);
			if(result != null){
				for(int i=0;i<result.length;i++)
					if(result[i]!=null)
						pw.println("<a href=details?name="+result[i]+">"+result[i]+"</a><br>");
			}
			else
				pw.println("No result FOUND !! ");
			} catch (SQLException e){ 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
