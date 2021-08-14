package com.app.org;

public class Worker extends Emp{
	private double hoursWorked,hourlyRate;

	public Worker(int id, String name, double basic, String Dept ,double hoursWorked, double hourlyRate) {
		super(id, name, basic, Dept);
		this.hourlyRate=hourlyRate;
		this.hoursWorked=hoursWorked;
	}
	public String toString() {
		return "Worker Data :" +super.toString()+" Hourly Rate: "+this.hourlyRate+" Hours Worked: "+this.hoursWorked+" ]";
	}
		public double computeNetSal() {
		return getBasic()+(this.hoursWorked*this.hourlyRate);
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
}
