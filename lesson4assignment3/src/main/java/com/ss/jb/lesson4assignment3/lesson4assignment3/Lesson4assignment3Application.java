package com.ss.jb.lesson4assignment3.lesson4assignment3;
import java.util.Random;

public class Lesson4assignment3Application {

	public static class BoundedBuffer {

		private static int[] arr = new int[100];

		private static BoundedBuffer instance;

		private static int lastLocation = 0;

		private BoundedBuffer() {};

		public static BoundedBuffer getInstance() {

			if (instance == null) {
				synchronized (BoundedBuffer.class) {
					if (instance == null) {
						instance = new BoundedBuffer();
					}
				}
        	}
	        return instance;
		};

		public void addNumber(int num) {
			arr[lastLocation] = num;
			lastLocation++;
		};

		public int returnLast() {
			return arr[lastLocation - 1];
		}

	};

	public static void main(String[] args) {
		Thread producer = new Thread() {
			public void run() {
				Random rand = new Random();
				int product = rand.nextInt(100);
				BoundedBuffer production = new BoundedBuffer();
				production.addNumber(product);
			};
		};
		Thread consumer = new Thread() {
			public void run() {
				BoundedBuffer consumption = new BoundedBuffer();
				System.out.println(consumption.returnLast());
			};
		};

		producer.start();
		consumer.start();
	}

}
