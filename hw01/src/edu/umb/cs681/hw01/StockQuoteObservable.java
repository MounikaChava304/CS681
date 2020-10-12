package edu.umb.cs681.hw01;

public class StockQuoteObservable extends Observable {

	public void changeQuote(String t, float q) {
		this.setChanged();
		this.notifyObservers(new StockEvent(t, q));
	}
}
