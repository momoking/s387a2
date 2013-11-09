package foreignKeyMappingPattern.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foreignKeyMappingPattern.domain.*;

/**
 * Servlet implementation class FetchForeignKeyMappingServlet
 */
@WebServlet("/FetchForeignKeyMappingServlet")
public class FetchForeignKeyMappingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	public FetchForeignKeyMappingServlet() {
		super();
	}
	
	 /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	AlbumMapper albumM = new AlbumMapper();
    	ArrayList<Album> albumList = new ArrayList<Album>();
    	
    	if (request.getParameter("choice").equals("byid")) {
    		Album found = new Album();
    		long l = Integer.parseInt(request.getParameter("searchfield"));
    		found = albumM.find(l);
    		albumList.add(found);
    	}else{
    		albumList = albumM.getAll();
    	}
    	
    	request.setAttribute("album", albumList);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/foreignKeyPattern/index.jsp");
    	dispatcher.forward(request, response);
    }
	
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    	doGet(request, response);
    }
}
