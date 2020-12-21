package edu.umb.cs681.hw15;

public class MultiThread {

	public static void main(String[] args) {

		AdmissionControl admission = new AdmissionControl();
		EntranceHandler entrance = new EntranceHandler(admission);
		ExitHandler exit_handler = new ExitHandler(admission);
		AdmissionMonitor monitor = new AdmissionMonitor(admission);

		Thread T_entrance = new Thread(entrance);
		Thread T_exit = new Thread(exit_handler);
		Thread T_monitor = new Thread(monitor);

		T_entrance.start();
		T_exit.start();
		T_monitor.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		entrance.setDone();
		exit_handler.setDone();
		monitor.setDone();

		T_entrance.interrupt();
		T_exit.interrupt();
		T_monitor.interrupt();

		try {
			T_entrance.join();
			T_exit.join();
			T_monitor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}