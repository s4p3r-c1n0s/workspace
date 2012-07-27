package employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] c = request.getCookies();
		Cookie ck = null,ck1 = null;
		if(c != null)
		for(int i=0;i<c.length;i++){
			if(c[i].getName().equals("login")) {ck = c[i];}
			else if(c[i].getName().equals("JSESSIONID")) {ck1 = c[i];}
		}
		if(ck != null || ck1 != null){
			
			ck.setMaxAge(0);
			ck1.setPath(request.getContextPath());
			ck1.setMaxAge(0);
			response.addCookie(ck);
			response.addCookie(ck1);
			HttpSession ses = request.getSession();
			ses.invalidate();
			response.sendRedirect("submitsignup?msg=You Have Successfully LOGGED OUT <br>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
