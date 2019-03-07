package edu.eci.arsw.GuidFinderAPI.model;

import java.util.UUID;

public class Guid {
	private String Fecha;
	private String guid;
	private double count;
	
	public Guid(){}
	
	public Guid(String fecha, String guid, double count){
		this.Fecha= fecha;
		this.guid = guid;
		this.count = count;
	}
	
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count=count;
	}
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid=guid;
	}
	
	public String getDate() {
		return Fecha;
	}
	
	public String setDate() {
		return Fecha;
	}
	
}
