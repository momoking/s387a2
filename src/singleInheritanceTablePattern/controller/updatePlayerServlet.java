package singleInheritanceTablePattern.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singleInheritanceTablePattern.domain.*;

/**
 * Servlet implementation class updatePlayerServlet
 */
@WebServlet("/updatePlayerServlet")
public class updatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("choice").equals("footballer")){
				Footballer footballer = (Footballer)(PlayerMapper.findPlayerById(Integer.parseInt(request.getParameter("Fid"))).get(0));
				footballer.setName(request.getParameter("Fname"));
				footballer.setClub(request.getParameter("Fclub"));
				FootballerMapper.updateDB(footballer);				
			}
			if (request.getParameter("choice").equals("cricketer")){
				Cricketer cricketer = (Cricketer)(PlayerMapper.findPlayerById(Integer.parseInt(request.getParameter("Cid"))).get(0));
				cricketer.setName(request.getParameter("Cname"));
				cricketer.setBatting_average(Integer.parseInt(request.getParameter("Cbat")));
				CricketerMapper.updateDB(cricketer);			
			}
			if (request.getParameter("choice").equals("bowler")){
				Bowler bowler = (Bowler)(PlayerMapper.findPlayerById(Integer.parseInt(request.getParameter("Bid"))).get(0));
				bowler.setName(request.getParameter("Bname"));
				bowler.setBatting_average(Integer.parseInt(request.getParameter("Bbat")));
				bowler.setBowling_average(Integer.parseInt(request.getParameter("Bbowl")));
				BowlerMapper.updateDB(bowler);			
			}
			request.setAttribute("updated", "Player has been modified!");
			forward("/singleTableInheritance/updatePlayer.jsp", request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void forward(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(target);
		dispatcher.forward(request,response);
	}

}
