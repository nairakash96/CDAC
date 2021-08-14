package com.app.org;

public abstract class Emp {
private int id;
private String name;
private double basic;
private String Dept;
public Emp(int id,String name,double basic,String Dept) {
	super();
	this.id=id;
	this.Dept=Dept;
	this.name=name;
	this.basic=basic;
}
public double getBasic() {
	return this.basic;
}
public int getId() {
	return id;
}
public abstract double computeNetSal();
public String toString() {
	return "[ EmpId= "+this.id+" Name: "+this.name+" Dept: "+this.Dept+" Basic: "+this.basic;
}		
	
}
