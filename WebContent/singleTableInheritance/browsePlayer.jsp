<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
td {
	width: 80px;
}
</style>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<%@ page import="singleInheritanceTablePattern.domain.*"%>
	<center>
		<h1>Single Inheritance Table Pattern Demo</h1>
	</center>
	<%@ include file="includes/menu.jsp"%>



	<div style="left: 450px; top: 150px; position: absolute;">
		<form action="/s387a2/BrowsePlayerServlet" method="get">
			<input type="radio" name="choice" value="all"> All <input
				type="radio" name="choice" value="byid"> By Id <input
				type="text" name="searchfield"> <input type="submit"
				value="  Find Player(s)  ">
		</form>
		<br>
		<br>

		<%
		    List<Player> players = (List<Player>) request.getAttribute("players");
		    if (players != null) {
		        if (players.size() != 0) {
		            out.println("<table border=" + 1 + "><tr><td align=" + "center" + ">Id</td><td align=" + "center"
		                    + ">Name</td><td align=" + "center" + ">Club</td>" + "<td align=" + "center"
		                    + ">Batting Avg</td><td align=" + "center" + ">Bowling Avg</td></tr>");
		            for (Player player : players) {
		                if (player instanceof Footballer) {
		                    out.println("<tr>" + "<td align=" + "center" + ">" + player.getId() + "</td>"
		                            + "<td align=" + "center" + ">" + player.getName() + "</td>" + "<td align="
		                            + "center" + ">" + ((Footballer) player).getClub() + "</td>" + "<td align="
		                            + "center" + ">---</td>" + "<td align=" + "center" + ">---</td>" + "</tr>");
		                } else if ((!(player instanceof Bowler)) && (player instanceof Cricketer)) {
		                    out.println("<tr>" + "<td align=" + "center" + ">" + player.getId() + "</td>"
		                            + "<td align=" + "center" + ">" + player.getName() + "</td>" + "<td align="
		                            + "center" + ">---</td>" + "<td align=" + "center" + ">"
		                            + ((Cricketer) player).getBatting_average() + "</td>" + "<td align=" + "center"
		                            + ">---" + "</td>" + "</tr>");
		                } else if ((player instanceof Cricketer) && (player instanceof Bowler)) {
		                    out.println("<tr>" + "<td align=" + "center" + ">" + player.getId() + "</td>"
		                            + "<td align=" + "center" + ">" + player.getName() + "</td>" + "<td align="
		                            + "center" + ">---</td>" + "<td align=" + "center" + ">"
		                            + ((Bowler) player).getBatting_average() + "</td>" + "<td align=" + "center" + ">"
		                            + ((Bowler) player).getBowling_average() + "</td>" + "</tr>");
		                } else {
		                    out.println("<tr>" + "<td align=" + "center" + ">" + player.getId() + "</td>"
		                            + "<td align=" + "center" + ">" + player.getName() + "</td>" + "<td align="
		                            + "center" + ">---</td>" + "<td align=" + "center" + ">---</td>" + "<td align="
		                            + "center" + ">---</td>" + "</tr>");
		                }
		            }
		        } else {
		            out.println("<p>No matching player found!</p>");
		        }
		    }
		%>
		</table>
	</div>
	</div>
</body>
</html>