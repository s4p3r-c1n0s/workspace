package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class submitsignup
 */
public class submitsignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitsignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] c = request.getCookies();
		PrintWriter pw = response.getWriter();
		String cval = null;
		if(c != null){
			for( int i=0 ;i < c.length ; i++){
				String cname = c[i].getName();
				if(cname.equals("login")) 
					cval = c[i].getValue();break;
			}
		}
		if(cval != null){
			RequestDispatcher rd = request.getRequestDispatcher("employee");
			rd.forward(request,response);
		}
		else {
			response.setContentType("text/html");
			String message = request.getParameter("msg");
			if(message!=null)
				pw.println(message);
			RequestDispatcher rd = request.getRequestDispatcher("default.html");
			rd.include(request,response);
			pw.println("<br><br>");
			RequestDispatcher rd1 = request.getRequestDispatcher("frameset.html");
			rd1.include(request,response);
		}
		
		/*Enumeration enu = request.getHeaderNames();
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String val = request.getHeader(name);
			pw.println(name+ " : "+val);
		}*/
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
