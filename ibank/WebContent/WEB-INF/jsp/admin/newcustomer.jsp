<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iBank - Administration</title>
<link rel="stylesheet" href="css/master.css" type="text/css" />
</head>
<body>
<div id="mask">
	<div id="header">
		<h1>iBank - Register New Customer</h1>
	</div>
	<div id="content-wrapper">
		<div id="leftcol-wrapper">
			<div id="leftcol"><jsp:include page="menu.jsp"/></div>
			<div id="content">
				<form:form method="post" commandName="customer">
					<form:errors path="*"/>
					<!-- userid, password, fname, lname, email, status -->
					<table>
						<tr><td>User ID</td><td><form:input path="userId"/></td></tr>
						<tr><td>Password</td><td><form:password path="password"/></td></tr>
						<tr><td>First Name</td><td><form:input path="firstName"/></td></tr>
						<tr><td>Last Name</td><td><form:input path="lastName"/></td></tr>
						<tr><td>E-mail</td><td><form:input path="email"/></td></tr>
						<tr><td>&nbsp;</td><td><input type="submit"/></td></tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<div id=clearfooter"></div>
</div>
<div id="footer" align="center">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>