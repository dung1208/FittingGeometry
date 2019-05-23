package utility;

import java.util.ArrayList;
import java.util.List;

import model.Point2D;

public class CommonMethod {

	/**
	 * round a double number
	 * 
	 * @param numberInput
	 * @return
	 */
	public static double roundNumber(double numberInput) {
		return Math.round(numberInput * CommonConst.EPSILON_NUMBER) / CommonConst.EPSILON_NUMBER;
	}

	/**
	 * solve equation
	 * 
	 * @param firstPoint
	 * @param secondPoint
	 * @return
	 */
	public static List<Double> solveEquationLine(Point2D firstPoint, Point2D secondPoint) {
		List<Double> listOutput = new ArrayList<Double>();
		double numberA = (firstPoint.getVerticalPoint() - secondPoint.getVerticalPoint())
				/ (firstPoint.getHorizontalPoint() - secondPoint.getHorizontalPoint());
		double numberB = (firstPoint.getHorizontalPoint() * secondPoint.getVerticalPoint()
				- secondPoint.getHorizontalPoint() * firstPoint.getVerticalPoint())
				/ (firstPoint.getHorizontalPoint() - secondPoint.getHorizontalPoint());

		listOutput.add(roundNumber(numberA));
		listOutput.add(roundNumber(numberB));

		return listOutput;
	}

	/**
	 * calculate distance of two number
	 * 
	 * @param numberX1
	 * @param numberY1
	 * @param numberX2
	 * @param numberY2
	 * @return
	 */
	public static double calculateDistance(double numberX1, double numberY1, double numberX2, double numberY2) {
		return Math.sqrt((numberX1 - numberX2) * (numberX1 - numberX2) + (numberY1 - numberY2) * (numberY1 - numberY2));
	}

	/**
	 * solve equation for circle
	 * 
	 * @param fisrtPoint
	 * @param secondPoint
	 * @param thirstPoint
	 * @return
	 */
	public static List<Double> solveEquationCircle(Point2D fisrtPoint, Point2D secondPoint, Point2D thirstPoint) {

		List<Double> listOutput = new ArrayList<Double>();

		double x1 = fisrtPoint.getHorizontalPoint();
		double x2 = secondPoint.getHorizontalPoint();
		double x3 = thirstPoint.getHorizontalPoint();
		double y1 = fisrtPoint.getVerticalPoint();
		double y2 = secondPoint.getVerticalPoint();
		double y3 = thirstPoint.getVerticalPoint();

		double numberA = ((x2 * x2 - x3 * x3 + y2 * y2 - y3 * y3) * (y1 - y2)
				- (x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2) * (y2 - y3))
				/ ((x2 - x3) * (y1 - y2) - (x1 - x2) * (y2 - y3));

		double numberB = ((x2 * x2 - x3 * x3 + y2 * y2 - y3 * y3) * (x1 - x2)
				- (x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2) * (x2 - x3))
				/ ((y2 - y3) * (x1 - x2) - (y1 - y2) * (x2 - x3));

		double numberC = (x1 - numberA) * (x1 - numberA) + (y1 - numberB) * (y1 - numberB);

		listOutput.add(roundNumber(numberA));
		listOutput.add(roundNumber(numberB));
		listOutput.add(roundNumber(numberC));

		return listOutput;
	}

	public static double calculateErrorNumberLine(double numberA1, double numberB1, double numberA2, double numberB2) {
		return Math.abs((numberA1 - numberA2)) / numberA1 + Math.abs(numberB1 - numberB2) / numberB1;
	}
}
