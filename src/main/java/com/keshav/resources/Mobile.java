package com.keshav.resources;

public class Mobile {
	int id;
	String name;
	String brand;
	int ram;
	
	public Mobile() {
		super();
	}
		
	public Mobile(int id, String name, String brand, int ram) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.ram = ram;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	
}
