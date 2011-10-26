package edu.depaul.se491.snotg.manager.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import edu.depaul.se491.snotg.UserProfile;
import edu.depaul.se491.snotg.manager.UserManager;


public class UserManagerImplTest {

	UserManager userMgr = new UserManagerImpl();

    
	@Test
	public void findUserProfileTest() {
		UserProfile userProf = userMgr.findUserProfile(12345L);
		assertNotNull(userProf);
		assertEquals(12345L, userProf.getUserKey().longValue());
		assertNotNull(userProf.getDescription());
		assertNotNull(userProf.getShout());
	}
}
