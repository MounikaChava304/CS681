package edu.umb.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer {
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;

	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}

	public void setDone() {
		lock.lock();
		try {
			done = false;
		} finally {
			lock.unlock();
		}
	}

	public void generatePrimeFactors() {
		long divisor = from;
		while (dividend != 1 && divisor <= to) {
			lock.lock();
			try {
				if (done) {
					System.out.println("Stopped generating prime factors.");
					this.factors.clear();
					break;
				}
				if (divisor > 2 && isEven(divisor)) {
					divisor++;
					continue;
				}
				if (dividend % divisor == 0) {
					factors.add(divisor);
					// ----
					System.out.println(divisor);
					// ----
					dividend /= divisor;
				} else {
					if (divisor == 2) {
						divisor++;
					} else {
						divisor += 2;
					}
				}
			} finally {
				lock.unlock();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}

		}
	}

	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(7, 2,
				100);
		Thread thread = new Thread(gen);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gen.setDone();
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// gen.getPrimeFactors().forEach( (Long prime)-> System.out.print(prime + ", ")
		// );
		System.out.println("Final result: " + gen.getPrimeFactors() + "\n");
	}

}