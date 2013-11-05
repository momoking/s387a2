<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%@ page import="java.util.ArrayList" %>
<%@ page import="identityFieldPattern.domain.Person" %>

<p>demo by Haiyue</p>

<form action="IndexServlet" method="get">
<input type="button" value="Get all data">
</form>


<table>
<%
if (request.getAttribute("persons") != null){
	ArrayList<Person> list =  (ArrayList<Person>) request.getAttribute("persons");
	
%>

<table>
<%	for (Person p:list){ %>
<tr><td><% p.getId(); %></td><td><% p.getName(); %></td></tr>
<% } %>
</table>
<% } %>


</body>
</html>