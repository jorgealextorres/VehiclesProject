package VehiclesProject.src.com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {

		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		this.wheels.addAll(frontWheels);
		this.wheels.addAll(backWheels);
	}

}
