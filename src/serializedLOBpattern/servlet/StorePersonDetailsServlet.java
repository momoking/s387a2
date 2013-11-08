package serializedLOBpattern.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.database.DBRegistry;

import serializedLOBpattern.domain.PersonDetails;
import serializedLOBpattern.domain.PersonPersist;

/**
 * Servlet implementation class StorePersonDetailsServlet
 */
@WebServlet("/StorePersonDetailsServlet")
public class StorePersonDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorePersonDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String namePerson = request.getParameter("namePerson");
		int agePerson = Integer.parseInt(request.getParameter("agePerson"));
		String genderPerson = request.getParameter("genderPerson");

		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
		PersonDetails person1 = new PersonDetails(namePerson, agePerson, genderPerson);
		PreparedStatement ps;
		try {
			ps = con
					.prepareStatement("INSERT INTO persondetails VALUES (?)");
			System.out.print(person1.toString());
			PersonPersist.write(person1, ps);
			ps.execute();
			ps.close();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM persondetails");
			
			PersonDetails[] persons = new PersonDetails[100];
			
			int i = 0;
			while (rs.next()) {
				Object obj = PersonPersist.read(rs, "val1");
				PersonDetails p = (PersonDetails) obj;
				persons[i] = p;
				//System.out.println(p.getName() + "\t" + p.getAge() + "\t"
					//	+ p.getSex());
				i = i+1;
			}
			rs.close();
			st.close();
			HttpSession session = request.getSession();
			session.setAttribute("serialize_persons", persons);
			session.setAttribute("numPersons", i);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/serializedLOBpatternJSP/index.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("EXCEPTION:" + e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
