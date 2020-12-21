package edu.umb.cs681.hw18;

@FunctionalInterface
public interface Observer {
	void update(Observable observable, Object object);
}