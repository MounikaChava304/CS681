
package edu.umb.cs681.hw17;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		Random random = new Random();
		int randomHtml = random.nextInt(2);
		while (true) {
			lock.lock();
			try {
				if (done) {
					System.out.println(Thread.currentThread().getName() + " Done.");
					break;
				}
			} finally {
				lock.unlock();
			}
			java.nio.file.Path path = null;
			switch (randomHtml) {
			case 0:
				path = java.nio.file.Paths.get("a.html");
				break;
			case 1:
				path = java.nio.file.Paths.get("b.html");
				break;

			default:
			}

			AccessCounter.getInstance().increment(path);
			AccessCounter.getInstance().getCount(path);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e);
				continue;
			}
		}
	}

	public static void main(String[] args) {

		RequestHandler r1 = new RequestHandler();
		RequestHandler r2 = new RequestHandler();
		RequestHandler r3 = new RequestHandler();
		RequestHandler r4 = new RequestHandler();
		RequestHandler r5 = new RequestHandler();
		RequestHandler r6 = new RequestHandler();
		RequestHandler r7 = new RequestHandler();
		RequestHandler r8 = new RequestHandler();
		RequestHandler r9 = new RequestHandler();
		RequestHandler r10 = new RequestHandler();

		Thread T1 = new Thread(r1);
		Thread T2 = new Thread(r2);
		Thread T3 = new Thread(r3);
		Thread T4 = new Thread(r4);
		Thread T5 = new Thread(r5);
		Thread T6 = new Thread(r6);
		Thread T7 = new Thread(r7);
		Thread T8 = new Thread(r8);
		Thread T9 = new Thread(r9);
		Thread T10 = new Thread(r10);

		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		T6.start();
		T7.start();
		T8.start();
		T9.start();
		T10.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		r1.setDone();
		r2.setDone();
		r3.setDone();
		r4.setDone();
		r5.setDone();
		r6.setDone();
		r7.setDone();
		r8.setDone();
		r9.setDone();
		r10.setDone();

		T1.interrupt();
		T2.interrupt();
		T3.interrupt();
		T4.interrupt();
		T5.interrupt();
		T6.interrupt();
		T7.interrupt();
		T8.interrupt();
		T9.interrupt();
		T10.interrupt();

		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
			T5.join();
			T6.join();
			T7.join();
			T8.join();
			T9.join();
			T10.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}