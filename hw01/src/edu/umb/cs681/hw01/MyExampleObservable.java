package edu.umb.cs681.hw01;

public class MyExampleObservable {
	public static void main(String args[]) {

		StockQuoteObservable stockQuote = new StockQuoteObservable();
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer 1 notified.");
		});
		stockQuote.changeQuote("Google", 1);
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer 2 notified.");
		});
		stockQuote.changeQuote("Apple", 2);

		DJIAQuoteObservable djiaQuote = new DJIAQuoteObservable();
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer 1 notified.");
		});
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer 2 notified.");
		});
		djiaQuote.changeQuote("ABCD", 143);
		djiaQuote.changeQuote("EFGH", 33);

	}
}
