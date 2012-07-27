

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		PrintWriter pw = response.getWriter();
		DOA doa = DOA.getObject();
		HashSet<state_city>  alsc = null;//new HashSet<state_city>();
		HttpSession ses = request.getSession();
		alsc = (HashSet<state_city>)ses.getAttribute("newstates");
		state_city SC = new state_city(request.getParameter("state"),request.getParameter("city"));
		if(alsc == null){
			alsc = new HashSet<state_city>();
		}
		alsc.add(SC);
		ses.setAttribute("newstates", alsc);
		pw.println("<center><b> <u>New Cities in Cacher : </u><br><table>");
		for(state_city sc:alsc ){
			pw.println("<tr><td>"+sc.getCity()+"</td><td>");
			pw.println(sc.getState()+"</td></tr>");
		}
		pw.println("</center></b></table>");
		RequestDispatcher rd = request.getRequestDispatcher("buttons.html"); 
		rd.include(request,response);
		/*try {
			pw.println(doa.setState_City(SC));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
