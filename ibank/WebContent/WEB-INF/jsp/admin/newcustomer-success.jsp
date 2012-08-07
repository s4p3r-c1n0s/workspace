<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>iBank - New Customer ${customer.userId} Registered Successfully</h1>;
	</div>
	<div id="content-wrapper">
		<div id="leftcol-wrapper">
			<div id="leftcol"><jsp:include page="menu.jsp"/></div>
			<div id="content">
				<table>
					<tr><td>System ID</td><td>${customer.id}</td></tr>
					<tr><td>User ID</td><td>${customer.userId}</td></tr>
					<tr><td>Password</td><td><i>secret</i></td></tr>
					<tr><td>First Name</td><td>${customer.firstName}</td></tr>
					<tr><td>Last Name</td><td>${customer.lastName}</td></tr>
					<tr><td>E-mail</td><td>${customer.email}</td></tr>
				</table>
				<a href="<%=request.getContextPath()%>/createcust.htm">Register Another Customer</a>
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