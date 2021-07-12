package com.ss.jb.lesson4assignent2.lesson4assignment2;

public class Lesson4assignment2Application {

	public static void main(String[] args) {
		final String resource1 = "First String";
		final String resource2 = "Second String";
		Thread threadOne = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread One Locked Resource 1");
		
					try { Thread.sleep(100);} catch (Exception e) {}
		
					synchronized (resource2) {
						System.out.println("Thread One Locked Resource 2");
					}
				}
			}
		};

		Thread threadTwo = new Thread() {
			public void run() {
			  	synchronized (resource2) {
					System.out.println("Thread Two Locked Resource 1");
		
					try { Thread.sleep(100);} catch (Exception e) {}
		
					synchronized (resource1) {
				  		System.out.println("Thread Two Locked Resource 1");
					}
				}
			}
		};

		threadOne.start();
		threadTwo.start();

	}

}
