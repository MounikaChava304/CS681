package edu.umb.cs681.hw15;

import java.util.concurrent.atomic.AtomicBoolean;

public class ExitHandler implements Runnable {
	private AdmissionControl control;
	public AtomicBoolean done = new AtomicBoolean(false);

	public ExitHandler(AdmissionControl control) {
		this.control = control;
	}

	public void setDone() {
		done.getAndSet(true);
	}

	public void run() {
		while (true) {
			if (done.get()) {
				System.out.println("\t Exit Terminated!");
				break;
			}
			control.exit();
		}
	}

}