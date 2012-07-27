<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>
<%@page import="AlbumCart.album"%>
<% 
HttpSession ses = request.getSession();
ArrayList<album> albumList = (ArrayList<album>)ses.getAttribute("Albums");
if(request.getParameter("msg")!=null)
	 out.println(request.getParameter("msg")+"<br>");
else 
	out.println("<br>");
%>

<center>
<br/><br/>
<form action="letsBuy">
Albums &nbsp 
<select name="album">
<%
for(album a:albumList){
	out.println("<option>"+a.getName());
}
%>
</select>
<br>
Enter Quantity to buy : &nbsp
<input type=text name=qty>
<br/><br/>
<input type=submit name=goto value=GoToCart>
&nbsp
<input type=submit name=goto value=GoBack>
</form>
</center>
</body>
</html>