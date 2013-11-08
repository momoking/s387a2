package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;

/**
 * Servlet implementation class InsertPlayerServlet
 */
@WebServlet("/InsertPlayerServlet")
public class InsertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayerServlet() {
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
				String name = request.getParameter("Fname");
				String club = request.getParameter("Fclub");
				Footballer footballer = new Footballer(name, club);
				FootballerMapper.insertToDB(footballer);				
			}
			if (request.getParameter("choice").equals("cricketer")){
				String name = request.getParameter("Cname");
				String batting_avg = request.getParameter("Cbat");
				Cricketer cricketer = new Cricketer(name, Integer.parseInt(batting_avg));
				CricketerMapper.insertToDB(cricketer);				
			}
			if (request.getParameter("choice").equals("bowler")){
				String name = request.getParameter("Bname");
				String batting_avg = request.getParameter("Bbat");
				String bowling_avg = request.getParameter("Bbowl");				
				Bowler bowler = new Bowler(name, Integer.parseInt(batting_avg), Integer.parseInt(bowling_avg));
				BowlerMapper.insertToDB(bowler);				
			}
			request.setAttribute("inserted", "New player has been added into the database!");
			forward("/insertPlayer.jsp", request, response);
			
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
