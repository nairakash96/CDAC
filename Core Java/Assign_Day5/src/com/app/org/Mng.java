package com.app.org;

public class Mng extends Emp {
	
	private double perfmonceBonus;
	public Mng(int id, String name, double basic, String Dept,double perfmonceBonus) {
		super(id, name, basic, Dept);
		this.perfmonceBonus=perfmonceBonus;
	}
	@Override
	public String toString() {
		return "Mannagaer Data :" +super.toString()+" Bonous "+this.perfmonceBonus+" ]";
	}
	public double getPerfmonceBonus() {
		return perfmonceBonus;
	}
	public void setPerfmonceBonus(double perfmonceBonus) {
		this.perfmonceBonus = perfmonceBonus;
	}
	public double computeNetSal() {
		return getBasic()+this.perfmonceBonus;
	}
}
