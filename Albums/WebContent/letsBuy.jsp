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
<% 
HttpSession ses = request.getSession();
HashMap<String,album> incart = (HashMap<String,album>)ses.getAttribute("incart");
%>
<center>
<br/><br/>
Albums : 
<form action="purchase"> 
<table>
<tr><th>Album name</th><th>Qty</th><th>PPU</th><th>Total Price</th></tr>
<%
double totalPur = 0.0;
Set s = incart.keySet();
Iterator it = s.iterator();
while(it.hasNext()){
String name = (String)it.next();
album Album = incart.get(name);
double  totalPrice = Album.getQty()* Album.getPrice();
totalPur += totalPrice;
%>
<tr><td><%=name%></td><td><%=Album.getQty()%></td><td><%=Album.getPrice()%></td><td><%=totalPrice %></td><tr>
<%} %>
</table>
<br/><br/>
<input type=hidden name=total value=<%=totalPur%>>
<input type=submit name=goto value=GoToCart>
&nbsp
<input type=submit name=goto value=GoToFirst>
&nbsp
<input type=submit name=goto value=PlaceOrder>
</form>
</center>
</body>
</html>