<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form  commandName="formdata">
Name: <form:input path="name"/><br>
Age: <form:input path="age"/><br>


<%-- Hobbies: <form:checkbox path="hobby" value="Music"/>
<form:checkbox path="hobby" value="Reading"/>
<form:checkbox path="hobby" value="Watching TV"/>
 --%>
 
 <%-- <form:checkboxes items="${webFrameworkList}" path="favFramework" /> --%>
 <form:select path="favFramework">
 <form:options items="${webFrameworkList}" />
 </form:select>
<input type=submit value=ok>
</form:form>
</body>
</html>