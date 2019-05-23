package logic;

import java.util.ArrayList;
import java.util.List;

import model.Point2D;

public class HHD02_MeanFilter {
	/**
	 * thuat toan loc trung binh
	 * 
	 * @param oldSetPoint
	 *            tap du lieu diem dau vao
	 * @return tap du lieu diem sau khi duoc loc trung binh
	 */
	public List<Point2D> meanFilter(List<Point2D> oldSetPoint) {
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

		// thuc hien loc trung binh
		for (int i = 0; i < size; i++) {
			oldSetPoint.get(i)
					.setHorizontalPoint((newSetPoint.get(i).getHorizontalPoint()
							+ newSetPoint.get(i + 1).getHorizontalPoint() + newSetPoint.get(i + 2).getHorizontalPoint()
							+ newSetPoint.get(i + 3).getHorizontalPoint() + newSetPoint.get(i + 4).getHorizontalPoint())
							/ 5);
			oldSetPoint.get(i)
					.setVerticalPoint((newSetPoint.get(i).getVerticalPoint() + newSetPoint.get(i + 1).getVerticalPoint()
							+ newSetPoint.get(i + 2).getVerticalPoint() + newSetPoint.get(i + 3).getVerticalPoint()
							+ newSetPoint.get(i + 4).getVerticalPoint()) / 5);
		}

		return oldSetPoint;
	}
}
