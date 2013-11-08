package singleInheritanceTablePattern.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singleInheritanceTablePattern.domain.Player;
import singleInheritanceTablePattern.domain.PlayerMapper;

/**
 * Servlet implementation class playerManagerServlet
 */
@WebServlet("/BrowsePlayerServlet")
public class BrowsePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowsePlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Player> players = new ArrayList<Player>();
		try {
			if (request.getParameter("choice").equals("all"))
				players = PlayerMapper.findAllPlayer();
			else
				players = PlayerMapper.findPlayerById(Integer.parseInt(request.getParameter("searchfield")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("players", players);
		forward("/singleTableInheritance/browsePlayer.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void forward(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(target);
		dispatcher.forward(request,response);
	}
}
