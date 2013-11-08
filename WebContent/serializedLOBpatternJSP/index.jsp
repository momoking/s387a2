<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title></title>
</head>
<body>
<a href="/s387a2/index.jsp">HOME</a>
	<h2>Serialized LOB Pattern</h2>

	<form action="/s387a2/StorePersonDetailsServlet" method="get">
		<input type="text" name="namePerson">
		<input type="text" name="agePerson">
		<input type="text" name="genderPerson">
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