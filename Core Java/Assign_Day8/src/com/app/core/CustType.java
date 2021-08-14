package com.app.core;

public enum CustType {
SILVER,GOLD,PLATINUM;
	
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
