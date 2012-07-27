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
 * Servlet implementation class validate
 */
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
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
				response.sendRedirect("submitsignup?msg="+msg);
			}
			else if(password.equals("")){
				msg = "No Password Defined <br>";
				response.sendRedirect("submitsignup?msg="+msg);
			}
			else if (doa.valid(name,password)){
				
				Cookie c = new Cookie("login",name);
				c.setMaxAge(60*60);
				//c.setSecure(true);
				response.addCookie(c);
				
				HttpSession ses = request.getSession();
				ses.setAttribute("namelog",name);
				ses.setMaxInactiveInterval(60*60);
				
				response.sendRedirect("employee");
				/*RequestDispatcher rd = request.getRequestDispatcher("employee");
				rd.forward(request,response);*/
			}
			else{
				msg = "Wrong Login, Please Try Again";
				response.sendRedirect("submitsignup?msg="+msg);
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
