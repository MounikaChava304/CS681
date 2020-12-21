package edu.umb.cs681.hw19;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private int colorCode;

	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(int colorCode, String make, String model, int mileage, int year, float price) {
		this.colorCode = colorCode;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public int getColorCode() {
		return this.colorCode;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return (int) price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(List<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--;
	}

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<>();

		cars.add(new Car(1111, "Toyota", "RAV4", 20, 2018, 10000));
		cars.add(new Car(1112, "BMW", "X1", 100, 2019, 20000));
		cars.add(new Car(1113, "Audi", "Q7", 200, 2015, 50000));
		cars.add(new Car(1114, "Mercedes", "SL550", 50, 2020, 15000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		Integer colorcode = cars.stream().parallel().map((Car car) -> car.getColorCode()).reduce(0,
				(result, carColorCode) -> result += carColorCode,
				(finalResult, intermediateResult) -> finalResult + intermediateResult);

		System.out.println("Sum Of Car Color Code\t: " + colorcode);

		Integer Mileage = cars.stream().parallel().map((Car car) -> car.getMileage()).reduce(0,
				(result, carMileage) -> {
					if (result == 0)
						return carMileage;
					else if (carMileage < result)
						return carMileage;
					else
						return result;
				});

		System.out.println("Minimum Car Mileage\t: " + Mileage);

		Integer Price = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
			if (result == 0)
				return carPrice;
			else if (carPrice > result)
				return carPrice;
			else
				return result;
		});

		System.out.println("Maximum Car Price \t: " + Price);

		Integer Make = cars.stream().parallel().map((Car car) -> car.getMake()).reduce(0, (result, carMake) -> ++result,
				(finalResult, intermediateResult) -> finalResult);

		System.out.println("Count of Car Make\t: " + Make);

	}
}