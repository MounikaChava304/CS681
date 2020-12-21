package edu.umb.cs681.hw14;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable {

	private ThreadSafeBankAccount account = null;
	public AtomicBoolean done = new AtomicBoolean(false);

	public WithdrawRunnable(ThreadSafeBankAccount account) {
		this.account = account;
	}

	public void setDone() {
		done.getAndSet(true);
	}

	@Override
	public void run() {

		while (true) {

			if (done.get()) {
				System.out.println(Thread.currentThread().getName() + "\t Withdrawl Success!");
				break;
			}

			System.out.println(Thread.currentThread().getName() + "\t Withdrawl in progress!");
			account.withdraw(200);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}
}