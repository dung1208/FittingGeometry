package logic;

import java.util.ArrayList;
import java.util.List;

import model.Point2D;

public class HHD01_MedianFilter {
	/**
	 * thuat toan loc trung vi
	 * 
	 * @param oldSetPoint
	 *            tap du lieu diem dau vao
	 * @return tap du lieu diem sau khi loc trung vi
	 */
	public List<Point2D> meadianFilterSetPoint(List<Point2D> oldSetPoint) {
		// kiem tra kich thuoc cua tap du lieu dau vao
		if (oldSetPoint == null || oldSetPoint.size() == 1 || oldSetPoint.size() == 2) {
			return oldSetPoint;
		}
		int size = oldSetPoint.size();
		// mo ron mang them 4 phan tu
		List<Point2D> newSetPoint = new ArrayList<Point2D>();
		// 2 phan tu dau tien
		newSetPoint.add(oldSetPoint.get(2));
		newSetPoint.add(oldSetPoint.get(1));
		// copy mang
		for (int i = 2; i <= size; i++) {
			newSetPoint.add(oldSetPoint.get(i - 1));
		}
		newSetPoint.add(oldSetPoint.get(size - 1));
		// 2 phan tu cuoi cung
		newSetPoint.add(oldSetPoint.get(size - 2));
		newSetPoint.add(oldSetPoint.get(size - 3));

		// thuc hien loc trung vi
		for (int i = 0; i < size; i++) {
			for (int j = i; j < i + 3; j++) {
				for (int k = i + 1; k < i + 4; k++) {
					if (newSetPoint.get(j).getHorizontalPoint() > newSetPoint.get(k).getHorizontalPoint()) {
						// thuc hien hoan doi 2 hoanh do
						double tempInt = newSetPoint.get(j).getHorizontalPoint();
						newSetPoint.get(j).setHorizontalPoint(newSetPoint.get(k).getHorizontalPoint());
						newSetPoint.get(k).setHorizontalPoint(tempInt);
					}
					if (newSetPoint.get(j).getVerticalPoint() > newSetPoint.get(k).getVerticalPoint()) {
						// thuc hien hoan doi gia tri cua 2 tung do
						double tempInt = newSetPoint.get(j).getVerticalPoint();
						newSetPoint.get(j).setVerticalPoint(newSetPoint.get(k).getVerticalPoint());
						newSetPoint.get(k).setVerticalPoint(tempInt);
					}
				}
			}
			// gan gia tri chp oldSetPint[i] boi newSetPoint[i+2]
			oldSetPoint.get(i).setHorizontalPoint(newSetPoint.get(i + 2).getHorizontalPoint());
			oldSetPoint.get(i).setVerticalPoint(newSetPoint.get(i + 2).getVerticalPoint());
		}

		return oldSetPoint;
	}
}
