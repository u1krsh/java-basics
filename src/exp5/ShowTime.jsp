<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>System Date and Time</title>
</head>
<body>
<h2>Current System Date and Time:</h2>
<%
java.util.Date currentDate = new java.util.Date();
out.println("<h3>" + currentDate.toString() + "</h3>");
%>
</body>
</html>