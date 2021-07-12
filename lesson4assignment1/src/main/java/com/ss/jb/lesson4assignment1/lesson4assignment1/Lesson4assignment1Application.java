package com.ss.jb.lesson4assignment1.lesson4assignment1;

public class Lesson4assignment1Application {

	public static class Singleton {

		public String test;

		private static Singleton instance;
  
		private Singleton() {}
  
		public static Singleton getInstance() {

			if (instance == null) {
				synchronized (Singleton.class) {
					if (instance == null) {
						instance = new Singleton();
					}
				}
        	}
	        return instance;
		}
    }

	public static void main(String[] args) {
		Singleton first = Singleton.getInstance();
		Singleton second = Singleton.getInstance();

		first.test = "Pickle";
		second.test = "Bagel";

		System.out.println(first.test);
		System.out.println(second.test);
	}

}
