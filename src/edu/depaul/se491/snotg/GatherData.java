package edu.depaul.se491.snotg;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GatherData extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession _session = request.getSession(true);
		String user = "snotg";
		//get user info from backing store
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + User.class.getName() + " where user == '"+user+"'";
		List<User> users = (List<User>) pm.newQuery(query).execute();
		for (User u : users)
		{
			//store data in session which is used to display to the user
			_session.setAttribute("user", u.getUserName());
//TODO - Needs to be fixed.  COmmented out 10-23 by michalak			
/*			_session.setAttribute("x", u.getxCoordinate());
			_session.setAttribute("y", u.getyCoordinate());
			_session.setAttribute("time", u.getTime());*/
		}
		
		//forward it away
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/DisplayInfo.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}//GatherData