

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class start
 */
public class start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		final DOA doa = DOA.getObject();
		final HttpSession ses = request.getSession();
		ses.setMaxInactiveInterval(60*60);
		HashSet<state_city> alsc = null;
		try {
			alsc = doa.getState_City();
			if(alsc == null)
				alsc = new HashSet<state_city>();
			else 
				ses.setAttribute("states",alsc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		Timer t = new Timer();
		TimerTask Tk = new TimerTask(){
			public void run(){
				HashSet<state_city> newalsc = (HashSet<state_city>)ses.getAttribute("newstates");
				try {
					doa.setState_City(newalsc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newalsc = null;
				ses.setAttribute("newstates", newalsc);
			}
		};
		t.schedule(Tk,1000,10000);
		RequestDispatcher rd = request.getRequestDispatcher("get.html");
		rd.include(request,response);
		pw.println("<center><b> <u>Cities in Database : </u><br><table>");
		for(state_city sc:alsc ){
			pw.println("<tr><td>"+sc.getCity()+"</td><td>");
			pw.println(sc.getState()+"</td></tr>");
		}
		pw.println("</center></b></table>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}