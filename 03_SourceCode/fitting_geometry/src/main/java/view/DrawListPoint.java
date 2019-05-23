package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JPanel;

import model.Point2D;
import utility.CommonConst;

@SuppressWarnings("serial")
public class DrawListPoint extends JPanel {

	private List<Point2D> listPoint;

	public DrawListPoint(List<Point2D> listPoint) {
		setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 5);
		setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN / 20 - 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 30 - 5);
		this.listPoint = listPoint;
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(Color.RED);
		for (Point2D point : listPoint) {
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
			graphics2d.draw(new Ellipse2D.Double(point.getHorizontalPoint(), point.getVerticalPoint(),
					CommonConst.RADIUS_POINT, CommonConst.RADIUS_POINT));
		}
	}
}
