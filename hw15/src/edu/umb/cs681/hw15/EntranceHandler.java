package edu.umb.cs681.hw15;

import java.util.concurrent.atomic.AtomicBoolean;

public class EntranceHandler implements Runnable {

	private AdmissionControl control;
	public AtomicBoolean done = new AtomicBoolean(false);

	public EntranceHandler(AdmissionControl control) {
		this.control = control;
	}

	public void setDone() {
		done.getAndSet(true);
	}

	@Override
	public void run() {
		while (true) {
			if (done.get()) {
				System.out.println("\t Entrance Terminated!");
				break;
			}
			control.enter();
		}
	}

}