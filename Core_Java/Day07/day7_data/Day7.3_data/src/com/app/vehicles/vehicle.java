package com.app.vehicles;

public class vehicle {
	private int regNo;
	private String colour;
	private double price;
	
	
	public vehicle(int regNo, String colour, double price) {
		this.regNo = regNo;
		this.colour = colour;
		this.price = price;
	}


	@Override
	public String toString() {
		return "vehicle [regNo=" + regNo + ", colour=" + colour + ", price=" + price + "]";
	}


	public int getRegNo() {
		return regNo;
	}
	
	
	
	

}
