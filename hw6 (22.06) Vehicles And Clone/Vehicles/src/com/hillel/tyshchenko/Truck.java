package com.hillel.tyshchenko;

/**
 * Created by roman on 23.05.16.
 */
public class Truck extends Vehicle1 {
    private int  capacity;
    
    public Truck(String model, String registrationNumber) {
		super(model, registrationNumber);
	}

	public Truck(String model, String registrationNumber, int capacity) {
		super(model, registrationNumber);
		this.capacity = capacity;
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Truck)) return false;
		if (!super.equals(o)) return false;

		Truck truck = (Truck) o;

		return capacity == truck.capacity;

	}

	@Override
	public int hashCode() {
		return capacity;
	}

	//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + capacity;
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Truck other = (Truck) obj;
//		if (capacity != other.capacity)
//			return false;
//		return true;
//	}


	@Override
	public String toString() {
		return "Truck{" +
				"capacity=" + capacity +
				'}';
	}
}
