package AlbumCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.jasper.tagplugins.jstl.core.Set;

/**
 * Servlet implementation class purchase
 */
public class purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession ses = request.getSession();
		HashMap<String,album> incart = (HashMap<String,album>)ses.getAttribute("incart");
		DOA doa = DOA.getObject();
		if(request.getParameter("goto").equals("GoToFirst")){
			response.sendRedirect("categoryFetch");
		}
		else if (request.getParameter("goto").equals("GoToCart")){
			response.sendRedirect("albumList.jsp");
		}
		else if(request.getParameter("goto").equals("PlaceOrder")){
				double totalPur = Double.parseDouble(request.getParameter("total"));
				PrintWriter pw = response.getWriter();
				pw.println(totalPur);
				try {
					Set s = incart.keySet();
					Iterator it = s.iterator();
					while(it.hasNext()){
						String name = (String)it.next();
						album Album = incart.get(name);
						doa.buyAlbum(Album.getName(),Album.getQty());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("purchase.jsp?totalPur="+totalPur);
				rd.forward(request,response);
		}
	}
	// TODO Auto-generated method stub
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
