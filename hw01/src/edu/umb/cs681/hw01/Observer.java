package edu.umb.cs681.hw01;

@FunctionalInterface
public interface Observer {
	void update(Observable observable, Object object);
}