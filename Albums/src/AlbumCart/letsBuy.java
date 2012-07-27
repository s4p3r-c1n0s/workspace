package AlbumCart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class letsBuy
 */
public class letsBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public letsBuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DOA doa = DOA.getObject();
		HttpSession ses = request.getSession();
		if(request.getParameter("goto").equals("GoBack")){
			response.sendRedirect("categoryFetch");
		}
		else if (request.getParameter("goto").equals("GoToCart"))
		{
			
				String albumName = request.getParameter("album");
				int albumQty = Integer.parseInt(request.getParameter("qty"));
				album Album = null;
				try {
					Album = doa.getAlbum(albumName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HashMap<String,album> incart = (HashMap<String,album>)ses.getAttribute("incart");
				
				if(incart!=null) {
					if(incart.get(albumName) != null){
						if(Album.getQty() >= albumQty + incart.get(albumName).getQty() ){
							Album.setQty(albumQty + incart.get(albumName).getQty());
						}	
						else{
							response.sendRedirect("albumList.jsp?category="+ses.getAttribute("category")+"&msg=Not Sufficient Records available");
						}
					}
					else{
						if(Album.getQty() >= albumQty ){
							Album.setQty(albumQty);
						}	
						else{
							response.sendRedirect("albumList.jsp?category="+ses.getAttribute("category")+"&msg=Not Sufficient Records available");
						}
					}
				}
				else{
					if(Album.getQty() >= albumQty){
						incart = new HashMap<String,album>();
						Album.setQty(albumQty);
					}
					else{
						response.sendRedirect("albumList.jsp?category="+ses.getAttribute("category")+"&msg=Not Sufficient Records available");
					}
				}
					incart.put(albumName,Album);
					ses.setAttribute("incart", incart);
					RequestDispatcher rd = request.getRequestDispatcher("letsBuy.jsp");
					rd.forward(request, response);
			
				}
			else {
				response.sendRedirect("albumList.jsp?category="+ses.getAttribute("category")+"&msg=Not Sufficient Records available");
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
