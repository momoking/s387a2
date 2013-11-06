package identityFieldPattern.servlet;

import identityFieldPattern.domain.Person;
import identityFieldPattern.domain.PersonManager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchIdentityFieldServlet
 */
@WebServlet("/FetchIdentityFieldServlet")
public class FetchIdentityFieldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchIdentityFieldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // System.out.println("called");
        PersonManager manager = new PersonManager();
        ArrayList<Person> list = new ArrayList<Person>();

        if (request.getParameter("choice").equals("byid")) {
            Person found = new Person();
            found = manager.find(Integer.parseInt(request.getParameter("searchfield")));
            list.add(found);
        } else {
            list = manager.getAll();
        }

        request.setAttribute("persons", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/identityFieldPattern/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

}
