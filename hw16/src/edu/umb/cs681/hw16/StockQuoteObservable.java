package edu.umb.cs681.hw16;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable {
	private Map<String, Float> ticker_quote = new HashMap<>();
	private ReentrantLock locks = new ReentrantLock();

	public void changeQuote(String tickers, float quote) {
		locks.lock();
		ticker_quote.put(tickers, quote);
		this.setChanged();
		this.notifyObservers(new StockEvent(tickers, quote));
		locks.unlock();
	}

	public void setQuote(String tickers, float quote) {
		locks.lock();
		ticker_quote.put(tickers, quote);
		this.setChanged();
		notifyObservers(new StockEvent(tickers, quote));
		locks.unlock();
	}
}