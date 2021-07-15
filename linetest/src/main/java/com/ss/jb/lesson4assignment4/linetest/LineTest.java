package com.ss.jb.lesson4assignment4.linetest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LineTest {

	Line testLine = new Line(-5, -1, 3, 4);

	@Test
	public void testGetSlope() {
		double result = testLine.getSlope();
		assertEquals(0.25, result, 0.0001);
		System.out.println("Slope Test Passed");
	};

	@Test
	public void testGetDistance() {
		double result = testLine.getDistance();
		assertEquals(4.123105463, result, 0.0001);
		System.out.println("Distance Test Passed");
	};

	@Test
	public void testParallelTo() {
		Line compareLine = new Line(-7, -3, 1, 2);
		assertEquals(testLine.parallelTo(compareLine), true);
		System.out.println("Parallel Test Passed");
	};

	public static void main(String[] args) {
		LineTest test = new LineTest();
		test.testGetSlope();
		test.testGetDistance();
		test.testParallelTo();
	}

}
