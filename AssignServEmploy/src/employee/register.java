package employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String msg = new String();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		DOA doa = DOA.getObject();
		try {
			if(name.equals("")){
				msg = "No User Name Defined <br>";
				response.sendRedirect("signupServ?msg="+msg);
			}
			else if(password.equals("")){
				msg = "No Password Defined <br>";
				response.sendRedirect("signupServ?msg="+msg);
			}
			else if (doa.enter(name,password) == 1){
				RequestDispatcher rd = request.getRequestDispatcher("registered");
				rd.include(request,response);
			}
			else{
				msg = "User Name exists <br>";
				response.sendRedirect("signupServ?msg="+msg);
			}
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
