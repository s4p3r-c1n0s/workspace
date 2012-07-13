package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FirstServlet() {
        super();
        System.out.println("Contructor called");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter put = response.getWriter();
		put.println(
"<html>"+
"<head>"+
"<meta http-equiv=Content-Type content=text/html; charset=UTF-8>"+
"<title>Heya</title>"+
"</head>"+
"<body>"+
"<center>"+
"Enter Name"+
"<input type=textfield name=password>"+ 
"<br>"+
"Enter Pass"+
"<input type=password name=password></input>"+
"<br><br>"+
"<input type=radio name=rad value=0>part 1"+
"<input type=radio name=rad value=1>part 2"+
"<br>"+
"<input type=radio name=rad value=1> part 3"+
"<input type=radio name=rad value=1> part 4"+
"<br>"+
"<br>"+
"<table>"+
"<th>"+
"<td>"+
"<input type=checkbox name=chk value=1>choice 1"+
"<br><br>"+
"<input type=checkbox name=chk value=1>choice 2"+
"<br><br>"+
"<input type=checkbox name=chk value=1>choice 3"+
"<br><br>"+
"</td>"+
"<td>"+
"<select name = opt1>"+
"<option>option 1"+
"<option>option 2"+
"<option>option 3"+
"<option>option 4"+
"<option>option 5"+
"</select>"+
"<br><br>"+
"<select name = opt2>"+
"<option>option 1"+
"<option>option 2"+
"<option>option 3"+
"<option>option 4"+
"<option>option 5"+
"</select>"+
"</td>"+
"<td>"+
"<select multiple name = lst>"+
"<option>Umang "+
"<option>Latika"+
"<option>Bhavay"+
"<option>Disha"+
"<option>Rajan"+
"</select>"+
"</td>"+
"</th>"+
"</table>"+
"<input type=submit name=submit value=Submit>"+ 
"</center>"+
"</body>"+
"</html>");		
	}
	
	public void init(){
		System.out.println("Insidie Init");
	}
	public void destroy(){
		
	}

}
