package VehiclesProject.src.com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public String getBrand() {
		return brand;
	}

	public double getDiameter() {
		return diameter;
	}

	@Override
	public String toString(){
		return "wheel [ brand : " + brand + ", diameter : " + diameter + " ] ";
	}

	@Override
	public boolean equals(Object o){
		if (o == this) {
			return true;
		}

		if (!(o instanceof Wheel)) {
			return false;
		}

		Wheel w = (Wheel) o;

		return (this.brand.equals(w.getBrand()) && Double.compare(this.diameter, w.getDiameter()) == 0);
	}
}
