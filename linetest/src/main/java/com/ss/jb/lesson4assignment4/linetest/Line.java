package com.ss.jb.lesson4assignment4.linetest;

public class Line {
	public double x1;
	public double x2;
	public double y1;
	public double y2;

	public Line(double x1, double x2, double y1, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	};

	public double getSlope() {
		return (y2 - y1) / (x2 - x1);
	};

	public double getDistance() {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	};

	public boolean parallelTo(Line line) {
		return this.getSlope() == line.getSlope();
	};

}