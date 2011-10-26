package edu.depaul.se491.snotg.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.snotg.UserProfile;
import edu.depaul.se491.snotg.manager.UserManager;
import edu.depaul.se491.snotg.manager.impl.UserManagerImpl;

public class UserServlet extends HttpServlet {
//TODO - create Factory to create concrete UserMgr
	UserManager userMgr = new UserManagerImpl(); 
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws IOException {
       
		com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

/*        if (user != null) {
            resp.setContentType("text/plain");
            resp.getWriter().println("Hello, " + user.getNickname());
        } else {
            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }*/
        
        UserProfile userProf = userMgr.findUserProfile(12345L);
		resp.getWriter().println("Response from GAE User Service - " + new Date());
    }
}
