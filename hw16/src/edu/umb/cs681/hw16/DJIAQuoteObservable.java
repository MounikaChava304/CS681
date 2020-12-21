package edu.umb.cs681.hw16;

import java.util.concurrent.locks.ReentrantLock;

public class DJIAQuoteObservable extends Observable {

	private ReentrantLock locks = new ReentrantLock();

	public void changeQuote(float quote) {
		locks.lock();
		this.setChanged();
		this.notifyObservers(new DJIAEvent(quote));
		locks.unlock();
	}

	public void setQuote(float quote) {
		locks.lock();
		this.setChanged();
		notifyObservers(new DJIAEvent(quote));
		locks.unlock();
	}

}