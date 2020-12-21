package edu.umb.cs681.hw13;

import java.nio.file.FileSystems;
import java.nio.file.Path;
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

		String[] files = { "AccessCounter.class", "RequestHandler.class", "a.html", "b.html" };
		AccessCounter ac = AccessCounter.getInstance();

		while (true) {
			lock.lock();
			try {
				if (done) {
					System.out.println("Stopped accessing files");
					break;
				}

				int num = new Random().nextInt(files.length);
				Path path = FileSystems.getDefault().getPath(".", files[num]);

				ac.increment(path);
				System.out.println(files[num] + " : " + ac.getCount(path));
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

	// create 10+ instances
	public static void main(String[] args) {
		RequestHandler r1 = new RequestHandler();
		RequestHandler r2 = new RequestHandler();
		RequestHandler r3 = new RequestHandler();
		RequestHandler r4 = new RequestHandler();
		RequestHandler r5 = new RequestHandler();

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		Thread t5 = new Thread(r5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

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

		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();
		t1.interrupt();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}