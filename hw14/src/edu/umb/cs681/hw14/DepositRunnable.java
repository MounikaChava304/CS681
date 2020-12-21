package edu.umb.cs681.hw14;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {

	private ThreadSafeBankAccount bankAccount = null;
	private AtomicBoolean done = new AtomicBoolean(false);

	public DepositRunnable(ThreadSafeBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void setDone() {
		done.getAndSet(true);
	}

	@Override
	public void run() {

		while (true) {

			if (done.get()) {
				System.out.println(Thread.currentThread().getName() + "\t Deposited money!");
				break;
			}

			System.out.println(Thread.currentThread().getName() + "\t Depositing money!");
			bankAccount.deposit(300);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}
}