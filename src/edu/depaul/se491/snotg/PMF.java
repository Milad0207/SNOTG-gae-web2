package edu.depaul.se491.snotg;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF
{
	private static final PersistenceManagerFactory mPmfInstance = JDOHelper.getPersistenceManagerFactory( "transactions-optional" );

	private PMF()
	{
	}

	public static PersistenceManagerFactory get()
	{
		return mPmfInstance;
	}
}
