package model;

public class Point2D {
	// hoanh do
	private double horizontalPoint;
	// tung do
	private double verticalPoint;

	public Point2D() {
		super();
	}

	public Point2D(int horizontalPoint, int verticalPoint) {
		super();
		this.horizontalPoint = horizontalPoint;
		this.verticalPoint = verticalPoint;
	}

	public double getHorizontalPoint() {
		return horizontalPoint;
	}

	public void setHorizontalPoint(double horizontalPoint) {
		this.horizontalPoint = horizontalPoint;
	}

	public double getVerticalPoint() {
		return verticalPoint;
	}

	public void setVerticalPoint(double verticalPoint) {
		this.verticalPoint = verticalPoint;
	}
}
