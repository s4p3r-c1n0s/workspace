<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*"%>
<%@page import="AlbumCart.album"%>
<%@page import="AlbumCart.DOA"%>
<% 
HttpSession ses = request.getSession();
double totalPur = Double.parseDouble(request.getParameter("totalPur"));
DOA doa = DOA.getObject();
HashSet<album> incart = doa.getAllAlbums();
%>

<center>
<h2> Your Total Purchase <br> Rs <%=totalPur %></h2>
<br/><br/>
Albums Left :  
<table>
<tr><th>Album name</th><th>Qty</th><th>PPU</th><th>Category</th></tr>
<%
Iterator it = incart.iterator();
while(it.hasNext()){
album Album = (album)it.next();
%>
<tr><td><%=Album.getName()%></td><td><%=Album.getQty()%></td><td><%=Album.getPrice()%></td><td><%=Album.getCategory() %></td><tr>
<%} %>
</table>
<br/><br/>
</center>
</body>
</html>