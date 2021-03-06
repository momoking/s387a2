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
	<%@ page import="identityFieldPattern.domain.Person"%>

	<h2>Identity Field Pattern Demo</h2>

	<c:if test="${empty persons}">
	</c:if>
	<form action="/s387a2/FetchIdentityFieldServlet" method="get">
		<input type="radio" name="choice" value="all" checked> all <input
			type="radio" name="choice" value="byid"> by id <input
			type="text" name="searchfield"> <input type="submit"
			value="Fetch Person Data">
	</form>
	<br />

	<table>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>Id: ${person.id}</td>
				<td>Name: ${person.name}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>