package com.app.vehicle;

public class Vehicle {
private String regNo;
private String color;
private double price;
public Vehicle(String regNo, String color, double price) {
	super();
	this.regNo = regNo;
	this.color = color;
	this.price = price;
}
@Override
public String toString() {
	return "Vehicle [regNo=" + regNo + ", color=" + color + ", price=" + price + "]";
}
public boolean equals(Vehicle otherVeh) {
	System.out.println("In vehicles equals");
	if(otherVeh instanceof Vehicle)
	return regNo.equals(otherVeh.regNo);
	return false;
}

}
