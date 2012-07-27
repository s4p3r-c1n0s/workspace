<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Upload Example</title>

</head>
<body>
<form  name="frm" method="post" action="uploadfile.htm"
	enctype="multipart/form-data" >
	
<input type="file" name="fileData"/>
	<input type="submit" value="Upload" />
	</form>
</body>
</html>