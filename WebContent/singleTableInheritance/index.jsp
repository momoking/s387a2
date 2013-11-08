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
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/singleTableInheritance/browsePlayer.jsp">Browse Players</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/singleTableInheritance/insertPlayer.jsp">Add New Player</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/singleTableInheritance/updatePlayer.jsp">Update Player</a></p>
<p style="margin-bottom: 10px;"><a href="<%= request.getContextPath() %>/singleTableInheritance/deletePlayer.jsp">Delete Player</a></p>
</div>

<div style="left: 450px; top: 150px; position: absolute;">	
</div>
</div>
</body>
</html>