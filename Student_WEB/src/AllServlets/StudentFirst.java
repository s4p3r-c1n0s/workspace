package AllServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentFirst
 */
public class StudentFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String str = request.getParameter("str");
/*		if(request.getHeader("referer")!=null){
			if(request.getHeader("referer").lastIndexOf("StudentFirst")>(-1))pw.println("Error");
			}*/
		if(str!=null){
			pw.println("Errors : "+str);
		}
	pw.println(
			"<html><head><meta http-equiv=Content-Type content=text/html; charset=UTF-8>"+
			"<title>Student Form</title></head><body>"+
			"<center>" +
			"<form action=Form_action method=get>"+
			"Enter Name<input type=text name=name><br>"+
			"Enter Pass<input type=password name=pass><br>"+
			"Enter Age <input type=text name=age><br><br>"+
			"<input type=radio name=sex value=M>Male"+
			"<input type=radio name=sex value=F>Female<br><br>"+
			"<select multiple name = course>" +
			"<option>PhyEdu"+
			"<option>Computers"+
			"<option>SST"+
			"<option>Science"+
			"<option>Maths"+
			"</select><br>"+
			"<input type=submit name=submit value=Submit>"+
			"</form>"+
			"</center>"+
			"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
