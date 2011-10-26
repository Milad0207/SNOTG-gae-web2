package edu.depaul.se491.snotg;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserProfile 
{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
    
    /**
     * FK to user creating/owning this profile
     */
    @Persistent
    private Long userKey;

    @Persistent
    private Blob avatar;
    
    @Persistent
    private String profileName;
    
    @Persistent
    private String description;
    
    // I.e. what's on my mind
    @Persistent
    private String shout;
    

    public UserProfile() { super();}
    
    public UserProfile(String profName) 
    {
    	this.profileName = profName;
    }
    
    public UserProfile(Key key, String profName) 
    {
    	this.key = key;
    	this.profileName = profName;
    }
    
    
    
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShout() {
		return shout;
	}

	public void setShout(String status) {
		this.shout = status;
	}

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}
    
}