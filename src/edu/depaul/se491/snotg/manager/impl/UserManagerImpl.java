package edu.depaul.se491.snotg.manager.impl;

import edu.depaul.se491.snotg.UserProfile;
import edu.depaul.se491.snotg.manager.UserManager;

public class UserManagerImpl implements UserManager {

	public UserProfile findUserProfile(Long key) {
		//TODO Create factories for these methods
		UserProfile usrProfile = new UserProfile();
		usrProfile.setUserKey(12345L);
		usrProfile.setDescription("This is my test professional profile for a Java Developer.  I am currently in SE at DePaul CDM");
		usrProfile.setProfileName("Homer the Java Developer");
		usrProfile.setShout("J2EE is just soooooo easy!");
		return usrProfile;
	}
}
