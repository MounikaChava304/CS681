package edu.umb.cs681.hw05;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		// With 1 thread
		System.out.println("--------------------------------------------------");
		RunnablePrimeGenerator g = new RunnablePrimeGenerator(1L, 2000000L);
		Thread t = new Thread(g);
		long start = System.currentTimeMillis();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
		}

		long end = System.currentTimeMillis();
		float time1 = (end - start) / 1000F;

		g.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		long primeNum1 = g.getPrimes().size();
		System.out.println("\n" + primeNum1 + " prime numbers are found in total.");
		System.out.println("Time taken with 1 thread: " + time1 + " seconds");

		// With 2 threads
		System.out.println("--------------------------------------------------");
		RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 1000000L);
		RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(1000000L, 2000000L);
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);

		start = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time2 = (end - start) / 1000F;

		long primeNum2 = g1.getPrimes().size() + g2.getPrimes().size();
		System.out.println("\n" + primeNum2 + " prime numbers are found in total.");
		System.out.println("Time taken with 2 threads: " + time2 + " seconds");

		// With 4 threads
		System.out.println("--------------------------------------------------");
		RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(1L, 500000L);
		RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(500000L, 1000000L);
		RunnablePrimeGenerator g5 = new RunnablePrimeGenerator(1000000L, 1500000L);
		RunnablePrimeGenerator g6 = new RunnablePrimeGenerator(1500000L, 2000000L);

		Thread t3 = new Thread(g3);
		Thread t4 = new Thread(g4);
		Thread t5 = new Thread(g5);
		Thread t6 = new Thread(g6);

		start = System.currentTimeMillis();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		try {
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time3 = (end - start) / 1000F;

		long primeNum4 = g3.getPrimes().size() + g4.getPrimes().size() + g5.getPrimes().size() + g6.getPrimes().size();
		System.out.println("\n" + primeNum4 + " prime numbers are found in total.");
		System.out.println("Time taken with 4 threads: " + time3 + " seconds");

		// With 8 threads
		System.out.println("--------------------------------------------------");
		RunnablePrimeGenerator g7 = new RunnablePrimeGenerator(1L, 250000L);
		RunnablePrimeGenerator g8 = new RunnablePrimeGenerator(250000L, 500000L);
		RunnablePrimeGenerator g9 = new RunnablePrimeGenerator(500000L, 750000L);
		RunnablePrimeGenerator g10 = new RunnablePrimeGenerator(750000L, 1000000L);
		RunnablePrimeGenerator g11 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator g12 = new RunnablePrimeGenerator(1250000L, 1500000L);
		RunnablePrimeGenerator g13 = new RunnablePrimeGenerator(1500000L, 1750000L);
		RunnablePrimeGenerator g14 = new RunnablePrimeGenerator(1750000L, 2000000L);

		Thread t7 = new Thread(g7);
		Thread t8 = new Thread(g8);
		Thread t9 = new Thread(g9);
		Thread t10 = new Thread(g10);
		Thread t11 = new Thread(g11);
		Thread t12 = new Thread(g12);
		Thread t13 = new Thread(g13);
		Thread t14 = new Thread(g14);

		start = System.currentTimeMillis();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		try {
			t7.join();
			t8.join();
			t9.join();
			t10.join();
			t11.join();
			t12.join();
			t13.join();
			t14.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time4 = (end - start) / 1000F;

		long primeNum8 = g7.getPrimes().size() + g8.getPrimes().size() + g9.getPrimes().size() + g10.getPrimes().size()
				+ g11.getPrimes().size() + g12.getPrimes().size() + g13.getPrimes().size() + g14.getPrimes().size();
		System.out.println("\n" + primeNum8 + " prime numbers are found in total.");
		System.out.println("Time taken with 8 threads: " + time4 + " seconds");

		// With 16 threads
		System.out.println("--------------------------------------------------");
		RunnablePrimeGenerator g15 = new RunnablePrimeGenerator(1L, 125000L);
		RunnablePrimeGenerator g16 = new RunnablePrimeGenerator(125000L, 250000L);
		RunnablePrimeGenerator g17 = new RunnablePrimeGenerator(250000L, 375000L);
		RunnablePrimeGenerator g18 = new RunnablePrimeGenerator(375000L, 500000L);
		RunnablePrimeGenerator g19 = new RunnablePrimeGenerator(500000L, 625000L);
		RunnablePrimeGenerator g20 = new RunnablePrimeGenerator(625000L, 750000L);
		RunnablePrimeGenerator g21 = new RunnablePrimeGenerator(750000L, 875000L);
		RunnablePrimeGenerator g22 = new RunnablePrimeGenerator(875000L, 1000000L);
		RunnablePrimeGenerator g23 = new RunnablePrimeGenerator(1000000L, 1125000L);
		RunnablePrimeGenerator g24 = new RunnablePrimeGenerator(1125000L, 1250000L);
		RunnablePrimeGenerator g25 = new RunnablePrimeGenerator(1250000L, 1375000L);
		RunnablePrimeGenerator g26 = new RunnablePrimeGenerator(1375000L, 1500000L);
		RunnablePrimeGenerator g27 = new RunnablePrimeGenerator(1500000L, 1625000L);
		RunnablePrimeGenerator g28 = new RunnablePrimeGenerator(1625000L, 1750000L);
		RunnablePrimeGenerator g29 = new RunnablePrimeGenerator(1750000L, 1875000L);
		RunnablePrimeGenerator g30 = new RunnablePrimeGenerator(1875000L, 2000000L);

		Thread t15 = new Thread(g15);
		Thread t16 = new Thread(g16);
		Thread t17 = new Thread(g17);
		Thread t18 = new Thread(g18);
		Thread t19 = new Thread(g19);
		Thread t20 = new Thread(g20);
		Thread t21 = new Thread(g21);
		Thread t22 = new Thread(g22);
		Thread t23 = new Thread(g23);
		Thread t24 = new Thread(g24);
		Thread t25 = new Thread(g25);
		Thread t26 = new Thread(g26);
		Thread t27 = new Thread(g27);
		Thread t28 = new Thread(g28);
		Thread t29 = new Thread(g29);
		Thread t30 = new Thread(g30);

		start = System.currentTimeMillis();
		t15.start();
		t16.start();
		t17.start();
		t18.start();
		t19.start();
		t20.start();
		t21.start();
		t22.start();
		t23.start();
		t24.start();
		t25.start();
		t26.start();
		t27.start();
		t28.start();
		t29.start();
		t30.start();
		try {
			t15.join();
			t16.join();
			t27.join();
			t18.join();
			t19.join();
			t20.join();
			t21.join();
			t22.join();
			t23.join();
			t24.join();
			t25.join();
			t26.join();
			t27.join();
			t28.join();
			t29.join();
			t30.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time5 = (end - start) / 1000F;

		long primeNum16 = g15.getPrimes().size() + g16.getPrimes().size() + g17.getPrimes().size()
				+ g18.getPrimes().size() + g19.getPrimes().size() + g20.getPrimes().size() + g21.getPrimes().size()
				+ g22.getPrimes().size() + g23.getPrimes().size() + g24.getPrimes().size() + g25.getPrimes().size()
				+ g26.getPrimes().size() + g27.getPrimes().size() + g28.getPrimes().size() + g29.getPrimes().size()
				+ g30.getPrimes().size();
		System.out.println("\n" + primeNum16 + " prime numbers are found in total.");
		System.out.println("Time taken with 16 threads: " + time5 + " seconds");
		System.out.println("--------------------------------------------------");
		System.out.println("# of Threads\t " + "Time in Seconds");
		System.out.println("\t 1 \t\t " + time1);
		System.out.println("\t 2 \t\t " + time2);
		System.out.println("\t 4 \t\t " + time3);
		System.out.println("\t 8 \t\t " + time4);
		System.out.println("\t 16 \t\t " + time5);

	}

}
