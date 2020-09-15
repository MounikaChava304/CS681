package edu.umb.cs681.hw01;

public class DJIAQuoteObservable extends Observable {
	void changeQuote(String t, float q) {
		setChanged();
		notifyObservers(new DJIAEvent(q));
	}
}
