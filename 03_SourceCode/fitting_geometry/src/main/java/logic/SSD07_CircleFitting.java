package logic;

import java.util.ArrayList;
import java.util.List;

import model.Point2D;
import utility.CommonConst;
import utility.CommonMethod;

public class SSD07_CircleFitting {
	/**
	 * fit circle by least mean squares
	 * 
	 * @param listPoint
	 * @return
	 */
	public List<Double> fitCircleByLMS(List<Point2D> listPoint) {
		List<Double> listOutput = new ArrayList<Double>();

		int sizeList = listPoint.size();

		double sumMeanX = 0;
		double sumMeanY = 0;

		for (int i = 0; i < sizeList; i++) {
			sumMeanX += listPoint.get(i).getHorizontalPoint() / sizeList;
			sumMeanY += listPoint.get(i).getVerticalPoint() / sizeList;
		}

		List<Double> listU = new ArrayList<Double>();
		List<Double> listV = new ArrayList<Double>();

		for (int i = 0; i < sizeList; i++) {
			listU.add(listPoint.get(i).getHorizontalPoint() - sumMeanX);
			listV.add(listPoint.get(i).getVerticalPoint() - sumMeanY);
		}

		double sumU2 = 0;
		double sumU3 = 0;
		double sumV2 = 0;
		double sumV3 = 0;
		double sumUV = 0;
		double sumUV2 = 0;
		double sumU2V = 0;

		for (int i = 0; i < sizeList; i++) {
			sumU2 += listU.get(i) * listU.get(i);
			sumU3 += listU.get(i) * listU.get(i) * listU.get(i);
			sumV2 += listV.get(i) * listV.get(i);
			sumV3 += listV.get(i) * listV.get(i) * listV.get(i);
			sumUV += listU.get(i) * listV.get(i);
			sumUV2 += listU.get(i) * listV.get(i) * listV.get(i);
			sumU2V += listU.get(i) * listU.get(i) * listV.get(i);
		}

		double numberA = ((sumU3 + sumUV2) * sumV2 - (sumV3 + sumU2V) * sumUV) / (2 * (sumU2 * sumV2 - sumUV * sumUV));
		double numberB = ((sumU3 + sumUV2) * sumUV - (sumV3 + sumU2V) * sumU2) / (2 * (sumUV * sumUV - sumU2 * sumV2));
		double numberC = numberA * numberA + numberB * numberB + (sumU2 + sumV2) / sizeList;

		listOutput.add(CommonMethod.roundNumber(numberA + sumMeanX));
		listOutput.add(CommonMethod.roundNumber(numberB + sumMeanY));
		listOutput.add(CommonMethod.roundNumber(numberC));
		return listOutput;
	}

	/**
	 * fit circle by ransac
	 * 
	 * @param listPoint
	 * @return
	 */
	public List<Double> fitCircleByRS(List<Point2D> listPoint) {
		List<Double> listOutput = new ArrayList<Double>();

		List<Integer> listCountSatisfyPoint = new ArrayList<Integer>();

		List<List<Double>> listCheckOutput = new ArrayList<List<Double>>();

		int sizeList = listPoint.size();
		for (int i = 0; i < sizeList; i++) {
			for (int j = i + 1; j < sizeList; j++) {
				for (int k = j + 1; k < sizeList; k++) {
					List<Double> listNumber = CommonMethod.solveEquationCircle(listPoint.get(i), listPoint.get(j),
							listPoint.get(k));
					int countSatisfyPoint = 0;
					for (int t = 0; t < sizeList; t++) {
						if ((CommonMethod.calculateDistance(listPoint.get(t).getHorizontalPoint(),
								listPoint.get(t).getVerticalPoint(), listNumber.get(0),
								listNumber.get(1)) < (Math.sqrt(listNumber.get(2)) + CommonConst.REGION_ERROR_NUMBER))
								&& ((CommonMethod.calculateDistance(listPoint.get(t).getHorizontalPoint(),
										listPoint.get(t).getVerticalPoint(), listNumber.get(0),
										listNumber.get(1))) > (Math.sqrt(listNumber.get(2))
												- CommonConst.REGION_ERROR_NUMBER))) {
							countSatisfyPoint++;
						}
					}
					listCountSatisfyPoint.add(countSatisfyPoint);
					listCheckOutput.add(listNumber);
				}
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
