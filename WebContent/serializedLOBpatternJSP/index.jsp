<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<h2>Serialized LOB Pattern</h2>

	<form action="/s387a2/StorePersonDetailsServlet" method="get">
		name:<input type="text" name="namePerson">
		age:<input type="text" name="agePerson">
		sex:<input type="text" name="genderPerson">
		<input type="submit" value="Add Person">
	</form>
	<br />

<%@ page import="serializedLOBpattern.domain.PersonDetails" %>
<%
PersonDetails[] persons = (PersonDetails[]) session.getAttribute("serialize_persons");
if (persons != null) {
	int numPersons = ((Integer) session.getAttribute("numPersons")).intValue();
	out.println("<table>");
	for(int i=0; i<numPersons; i++) {
		out.println("<tr><td>" + persons[i].getName() + " : " + persons[i].getAge() + " : " + persons[i].getSex() + " </td></tr>");
	}
	out.println("</table>");
} %>
</body>
</html>