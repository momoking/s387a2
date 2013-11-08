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


<div style="left: 350px; top: 150px; position: absolute;">	
	<form action="/s387a2/InsertPlayerServlet" method="post">
		<div>
		<input type="radio" name="choice" value="footballer">Footballer:&nbsp;&nbsp;   
		Name<input type="text" name="Fname">&nbsp;&nbsp;&nbsp;
		Club&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Fclub"> 
		</div>
		<br>
		<div>
		<input type="radio" name="choice" value="cricketer">Cricketer:&nbsp;&nbsp;&nbsp;      
		Name<input type="text" name="Cname">&nbsp;&nbsp;&nbsp;
		Batting Avg<input type="text" name="Cbat"> 
		</div>
		<br>
		<div>
		<input type="radio" name="choice" value="bowler">Bowler:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
		Name<input type="text" name="Bname">&nbsp;&nbsp;&nbsp;
		Batting Avg<input type="text" name="Bbat">&nbsp;&nbsp;&nbsp;
		Bowling Avg<input type="text" name="Bbowl">  
		</div>
		<br><br>
		<input type="submit" value="  Add  ">
	</form>
	<br>
	<%
		String s = (String) request.getAttribute("inserted");
		if (s == null)
			s = "";
	%>
	<p><%=s%></p>
		</div>
</div>
</body>
</html>