package com.app.vehicles;

public class Vehicle {
	private int regNo;
	private String colour;
	private double price;
	
	
	public Vehicle(int regNo, String colour, double price) {
		this.regNo = regNo;
		this.colour = colour;
		this.price = price;
	}


	// override toString to replace hashCode version by actual state details
	@Override
	public String toString() {
		return "vehicle [regNo=" + regNo + ", colour=" + colour + ", price=" + price + "]";
	}


	public int getRegNo() {
		return regNo;
	}
	
	
	// override equals method to replace reference equality by content equality
	@Override
	public boolean equals(Object obj) {
		System.out.println("in vehicle equles");
		if(obj instanceof Vehicle)
		return this.regNo==((Vehicle)obj).regNo;
		return false;
	}
	
	
	

}
