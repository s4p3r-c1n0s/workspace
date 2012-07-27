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
<% 
ArrayList<String> categoryList = (ArrayList<String>)request.getAttribute("List");
%>
<center>
<br/><br/>
<form action="albumList">
Categories &nbsp 
<select name="category">
<%
for(String a:categoryList){
	out.println("<option>"+a);
}
%>
</select>
<br/><br/>
<input type=submit name=submit value=submit>
</form>
</center>
</body>
</html>