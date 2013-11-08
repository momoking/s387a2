<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<center><h1>Single Inheritance Table Pattern Demo</h1></center>
<div style="margin-top: 50px;">
<div style="border-right: 1px solid #0099cc; height: 500px; width: 150px; position: absolute;">
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/browsePlayer.jsp">Browse Players</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/insertPlayer.jsp">Add New Player</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/updatePlayer.jsp">Update Player</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/deletePlayer.jsp">Delete Player</a></p>
</div>

<div style="left: 450px; top: 150px; position: absolute;">	
	<form action="DeletePlayerServlet" method="post">
		Delete Player:&nbsp;&nbsp;Id&nbsp;&nbsp;<input type="text" name="idToDelete">
		<input type="submit" value="  Delete  ">
	</form>
	<br>
	<%
		String s = (String) request.getAttribute("deleted");
		if (s == null)
			s = "";
	%>
	<p><%=s%></p>
</div>
</div>
</body>
</html>