package edu.umb.cs681.hw03;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String make, model;
	private int mileage, year;
	private int price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, int price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
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

	public int getDominationCount() {
		return this.dominationCount;
	}

	public static void main(String args[]) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Toyota", "RAV4", 20, 2018, 10000));
		cars.add(new Car("BMW", "X1", 100, 2019, 20000));
		cars.add(new Car("Audi", "Q7", 200, 2015, 50000));
		cars.add(new Car("Mercedes", "SL550", 50, 2020, 15000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		Integer minPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, price) -> {
			if (result == 0)
				return price;
			else if (price < result)
				return price;
			else
				return result;
		});

		System.out.println("Minimum price in the list of cars is: " + minPrice);

		Integer maxMileage = cars.stream().map((Car car) -> car.getMileage()).reduce(0, (result, mileage) -> {
			if (result == 0)
				return mileage;
			else if (mileage > result)
				return mileage;
			else
				return result;
		});

		System.out.println("Max mileage in the list of cars is: " + maxMileage);

		Integer numberOfCars = cars.stream().map((Car car) -> car.getMake()).reduce(0, (result, make) -> ++result,
				(finalResult, intermediateResult) -> finalResult);

		System.out.println("Number of cars in the list is: " + numberOfCars);
	}
}
