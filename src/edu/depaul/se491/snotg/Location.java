package edu.depaul.se491.snotg;

import java.sql.Timestamp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Location 
{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private double xCoordinate;
    
    @Persistent
    private double yCoordinate;
    
    //TODO - ADD geo location.  I am not sure of data type to create now.
        
    @Persistent
    private Timestamp lastUpdated;
    
    //TODO proximity - data type for this is not known
    
    
    public Location() { super();}
    
    public Location(Double _x, Double _y)
    {
    	this.xCoordinate = _x;
    	this.yCoordinate = _y;
    }
    
    //TODO - add geoLoc constructor
    
    
    
    public Key getKey() {
        return key;
    }

    public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}