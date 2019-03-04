package VehiclesProject.src.com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {

	}

	public String toString(){
		return " Vechicle [ plate : " + plate + ", brand : " + brand + ", color : " + color + ", weels : " + wheels.toString() + " ] ";
	}
}
