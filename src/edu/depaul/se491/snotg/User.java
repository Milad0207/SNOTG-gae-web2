package edu.depaul.se491.snotg;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User 
{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String userName;
    
    /**
     * Default user picture.  Can be overridden with profile's avatar image
     */
    @Persistent
    private Blob picture;
    
    //TODO CREATE a user status indicator either here or in UserSession object
    
    
    
    public User() { super();}
    
    public User(Key key, String usrName)
    {
    	this.key = key;
    	this.userName = usrName;
    }

    public User(String usrName)
    {
    	this.userName = usrName;
    }
    
    public User(Key key, String usrName, Blob usrPic)
    {
    	this.key = key;
    	this.userName = usrName;
    	this.picture = usrPic;
    }
    
    
    
    public Key getKey() {
        return key;
    }
    
	public void setKey(Key key) {
		this.key = key;
	}

    public void setUserName(String user)
    {
    	this.userName = user;
    }
    
    public String getUserName()
    {
    	return userName;
    }

	public byte[] getImage()
	{
		if (picture == null)
			return null;
		return picture.getBytes();
	}
	
	public void setImage(byte[] _bytes)
	{
		this.picture = new Blob(_bytes);
	}
}