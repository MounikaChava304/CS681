package edu.umb.cs681.hw12;

public class MultiThread implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MultiThread());
		Thread t2 = new Thread(new MultiThread());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void run() {
		Customer customer = new Customer(new Address("34 Silver Hill Ln", "Natick", "MA", 01760));
		customer.setAddress(customer.getAddress().change("111 Trailside Way", "Ashland", "MA", 01721));
		customer.getAddress();
		customer.setAddress(new Address("1500 Worcester Rd", "Framingham", "MA", 01701));
		System.out.println(customer.getAddress());
	}
}