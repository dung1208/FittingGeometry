package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Point2D;
import utility.CommonConst;
import utility.CommonMethod;

public class SSD04_CreateSetPoint {

	/**
	 * random point for fit line
	 * 
	 * @param numberA
	 * @param numberB
	 * @param countPoint
	 * @return
	 */
	public List<Point2D> createListPointLine(double numberA, double numberB, int countPoint) {
		Random random = new Random();
		List<Point2D> listPoint = new ArrayList<Point2D>();
		int countNoisyPoint = (int) (countPoint * CommonConst.RATIO_NOISY_POINT);

		double numberX = 0;
		double numberY = 0;

		while (listPoint.size() < countNoisyPoint) {
			numberX = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 1)
					/ CommonConst.EPSILON_NUMBER;
			numberY = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 1)
					/ CommonConst.EPSILON_NUMBER;
			if (Math.abs((numberA * numberX - numberY + numberB)
					/ (Math.sqrt(numberA * numberA + 1))) < CommonConst.REGION_ERROR_NUMBER_2) {
				Point2D point = new Point2D();
				point.setHorizontalPoint(numberX);
				point.setVerticalPoint(numberY);
				listPoint.add(point);
			}
		}

		while (listPoint.size() < countPoint) {
			numberX = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 1)
					/ CommonConst.EPSILON_NUMBER;
			numberY = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 1)
					/ CommonConst.EPSILON_NUMBER;
			if (Math.abs((numberA * numberX - numberY + numberB)
					/ (Math.sqrt(numberA * numberA + 1))) < CommonConst.REGION_ERROR_NUMBER) {
				Point2D point = new Point2D();
				point.setHorizontalPoint(numberX);
				point.setVerticalPoint(numberY);
				listPoint.add(point);
			}
		}
		return listPoint;
	}

	/**
	 * random point for fit circle
	 * 
	 * @param numberA
	 * @param numberB
	 * @param numberC
	 * @param countPoint
	 * @return
	 */
	public List<Point2D> createListPointCircle(double numberA, double numberB, double numberC, int countPoint) {
		List<Point2D> listPoint = new ArrayList<Point2D>();

		Random random = new Random();
		int countPointNoisy = (int) (countPoint * CommonConst.RATIO_NOISY_POINT);

		double numberX = 0;
		double numberY = 0;

		while (listPoint.size() < countPointNoisy) {
			numberX = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 1)
					/ CommonConst.EPSILON_NUMBER;
			numberY = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 1)
					/ CommonConst.EPSILON_NUMBER;
			if ((CommonMethod.calculateDistance(numberA, numberB, numberX,
					numberY) > (Math.sqrt(numberC) + CommonConst.REGION_ERROR_NUMBER_2)
					&& (CommonMethod.calculateDistance(numberA, numberB, numberX,
							numberY) < (Math.sqrt(numberC) + 5 * CommonConst.REGION_ERROR_NUMBER_2)))
					|| (CommonMethod.calculateDistance(numberA, numberB, numberX,
							numberY) < (Math.sqrt(numberC) - CommonConst.REGION_ERROR_NUMBER_2))) {
				Point2D point2d = new Point2D();
				point2d.setHorizontalPoint(numberX);
				point2d.setVerticalPoint(numberY);

				listPoint.add(point2d);
			}
		}

		while (listPoint.size() < countPoint) {
			numberX = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 1)
					/ CommonConst.EPSILON_NUMBER;
			numberY = Math
					.round(random.nextDouble() * CommonConst.EPSILON_NUMBER
							* CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 1)
					/ CommonConst.EPSILON_NUMBER;
			if ((CommonMethod.calculateDistance(numberA, numberB, numberX,
					numberY) < (Math.sqrt(numberC) + CommonConst.REGION_ERROR_NUMBER))
					&& (CommonMethod.calculateDistance(numberA, numberB, numberX,
							numberY) > (Math.sqrt(numberC) - CommonConst.REGION_ERROR_NUMBER))) {
				Point2D point2d = new Point2D();
				point2d.setHorizontalPoint(numberX);
				point2d.setVerticalPoint(numberY);

				listPoint.add(point2d);
			}
		}

		return listPoint;
	}
}
