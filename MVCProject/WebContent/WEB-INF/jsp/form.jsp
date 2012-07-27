<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form commandName="test">
<form:input path="id"/> <form:errors path="id"></form:errors>
<form:input path="name"/> <form:errors path="name"></form:errors>
<input type=submit value="OK">

</form:form>
<%--  <form action="form.req" method="post">
<spring:bind path="test.id">
	<td>
		<input type="text" size="30" name="<c:out value='${status.expression}'/>"
			value="<c:out value='${status.displayValue}' />"
		/>
	</td>
	<td>
		<c:if test="${status.error}">
			<div class="error">
				<c:forEach items="${status.errorMessages}"
						 		var="error">
					<c:out value="${error}"/>
				</c:forEach>
			</div>
		</c:if>
	</td>
	
</spring:bind>
<spring:bind path="test.name">
	<td>
		<input type="text" size="30" name="<c:out value='${status.expression}'/>"
			value="<c:out value='${status.displayValue}' />"
		/>
	</td>
	<td>
		<c:if test="${status.error}">
			<div class="error">
				<c:forEach items="${status.errorMessages}"
						 		var="error">
					<c:out value="${error}"/>
				</c:forEach>
			</div>
		</c:if>
	</td>
	
</spring:bind>
<td>
	<input type="Submit"/>
	</td>
 </form>--%>
 
</body>
</html>