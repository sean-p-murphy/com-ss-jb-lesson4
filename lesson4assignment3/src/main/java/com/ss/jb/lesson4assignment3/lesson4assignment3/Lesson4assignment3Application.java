package com.ss.jb.lesson4assignment3.lesson4assignment3;
import java.util.LinkedList;

public class Lesson4assignment3Application {

	public static class PC {

		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {
					while (list.size() == capacity) {
						wait();
					};
					System.out.println("Produced Value : " + value);
					list.add(value);
					value++;
					notify();
					Thread.sleep(500);
				}
			}
		}

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					while (list.size() == 0) {
						wait();
					}
					int value = list.getFirst();
					list.removeFirst();
					System.out.println("Consumed Value : " + value);
					notify();
					Thread.sleep(500);
				}
			}
		}
	}

	public static void main (String[] args) throws InterruptedException {

		final PC pc = new PC();

		Thread threadPro = new Thread() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread threadCon = new Thread() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		threadPro.start();
		threadCon.start();

		threadPro.join();
		threadCon.join();
	}

}
