package logic;

import java.util.ArrayList;
import java.util.List;

import model.Point2D;
import utility.CommonConst;
import utility.CommonMethod;

public class SSD05_LineFitting {

	/**
	 * algorithm Least mean squares fit line
	 * 
	 * @param listPoint
	 *            list point input source
	 * @return value a,b of line y = ax + b
	 */
	public List<Double> fitLineByLMS(List<Point2D> listPoint) {
		List<Double> listOutput = new ArrayList<Double>();
		// size of list input data
		int listSize = listPoint.size();
		double sumX2 = 0;
		double sumX = 0;
		double sumY = 0;
		double sumXY = 0;

		for (int i = 0; i < listSize; i++) {
			sumX2 += listPoint.get(i).getHorizontalPoint() * listPoint.get(i).getHorizontalPoint();
			sumX += listPoint.get(i).getHorizontalPoint();
			sumY += listPoint.get(i).getVerticalPoint();
			sumXY += listPoint.get(i).getHorizontalPoint() * listPoint.get(i).getVerticalPoint();
		}

		// calculate two number need to export
		double numberB = (sumY * sumX2 - sumX * sumXY) / (listSize * sumX2 - sumX * sumX);
		double numberA = (listSize * sumXY - sumX * sumY) / (listSize * sumX2 - sumX * sumX);

		// rounded double number
		listOutput.add(CommonMethod.roundNumber(numberA));
		listOutput.add(CommonMethod.roundNumber(numberB));

		return listOutput;
	}

	/**
	 * algorithm ranSac fit line
	 * 
	 * @param listPoint
	 *            list point input
	 * @return
	 */
	public List<Double> fitLineByRS(List<Point2D> listPoint) {
		// save two number output
		List<Double> listOutput = new ArrayList<Double>();
		// save list count point satisfy with each line
		List<Integer> listCountSatisfyPoint = new ArrayList<Integer>();

		List<List<Double>> listCheckOutput = new ArrayList<List<Double>>();

		// size of list data input
		int listSize = listPoint.size();
		for (int i = 0; i < listSize; i++) {
			for (int j = i + 1; j < listSize; j++) {
				// create line from two point
				List<Double> listNumber = CommonMethod.solveEquationLine(listPoint.get(i), listPoint.get(j));
				// count point satisfy condition
				int countSatisfyPoint = 0;
				for (int k = 0; k < listSize && k != i && k != j; k++) {
					if ((listNumber.get(0) * listPoint.get(k).getHorizontalPoint() + listNumber.get(1)
							- listPoint.get(k).getVerticalPoint())
							/ (Math.sqrt(
									listNumber.get(0) * listNumber.get(0) + 1)) < CommonConst.REGION_ERROR_NUMBER) {
						countSatisfyPoint++;
					}
				}
				listCountSatisfyPoint.add(countSatisfyPoint);
				listCheckOutput.add(listNumber);
			}
		}

		int sizeCheck = listCountSatisfyPoint.size();

		int maxIndexNumber = 0;
		int maxNumber = 0;

		for (int i = 0; i < sizeCheck; i++) {
			if (listCountSatisfyPoint.get(i) > maxNumber) {
				maxNumber = listCountSatisfyPoint.get(i);
				maxIndexNumber = i;
			}
		}

		listOutput = listCheckOutput.get(maxIndexNumber);

		return listOutput;
	}
}
