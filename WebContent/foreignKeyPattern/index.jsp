<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Foreign Key Mapping</title>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	
	<h2>Foreign Key Mapping Pattern Demo</h2>
	<h4>Choose to display all the information about the artists and the albums or only the album's id:</h4>
	
	<c:if test="${empty album}">
	</c:if>
	<form action="/s387a2/FetchForeignKeyMappingServlet" method="get">
		<input type="radio" name="choice" value="all" checked> all information <br/>
		<input type="radio" name="choice" value="byid"> album id
		<input type="text" name="searchfield"> <br/><br/>
		<input type="submit" value="Fetch Person Data">
	</form>
	<br />

	<table>
		<c:forEach items="${album}" var="album">
			<tr>
				<td>Id: ${album.id}</td>
				<td>Title: ${album.title}</td>
				<td>Artist: ${album.artist}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>