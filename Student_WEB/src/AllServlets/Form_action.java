package AllServlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form_action
 */
public class Form_action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String password = request.getParameter("pass");
		String name = request.getParameter("name");
		String ageString = request.getParameter("age");
		String sexString = request.getParameter("sex");
		String course[] = request.getParameterValues("course") ;
		String str = "";
		if(ageString.equals("") || sexString.equals("") ||  name.equals("") || password.equals("")){
			str += "TOO MANY ERRORS";
			response.sendRedirect("StudentFirst?str="+str);
		}
		else{
			int age = Integer.parseInt(ageString);
			char sex = sexString.charAt(0);
			Student s = new Student(name,age,password,sex,course);
			request.setAttribute("Student",s);
			RequestDispatcher rd = request.getRequestDispatcher("Final");
			rd.forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
