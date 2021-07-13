package com.ss.jb.lesson4assignment3.lesson4assignment3;
import java.util.Random;

public class Lesson4assignment3Application {

	public static class BoundedBuffer {

		private int[] arr = new int[100];

		private static BoundedBuffer instance;

		private int location = 0;

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

		public void addNumber(int input) {
			arr[location] = input;
			location++;
		};

		public int returnLast() {
			return arr[location - 1];
		}

	};

	public static void main(String[] args) {
		Thread producer = new Thread() {
			public void run() {
				Random rand = new Random();
				int product = rand.nextInt(100);
				BoundedBuffer production = BoundedBuffer.getInstance();
				production.addNumber(product);
			};
		};
		Thread consumer = new Thread() {
			public void run() {
				BoundedBuffer consumption = BoundedBuffer.getInstance();
				System.out.println(consumption.returnLast());
			};
		};

		producer.start();
		consumer.start();
	}

}
