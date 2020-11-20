<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<div align="center">

<form  action="result.jsp" method="post">

    <h2>Result: <%= request.getSession().getAttribute("result") %> </h2>

</form>

</body>
</html>