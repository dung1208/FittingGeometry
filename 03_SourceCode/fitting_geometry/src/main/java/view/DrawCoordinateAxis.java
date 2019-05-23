package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import utility.CommonConst;

@SuppressWarnings("serial")
public class DrawCoordinateAxis extends JPanel {

	public DrawCoordinateAxis() {
		setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 5);
		setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN / 20 - 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 30 - 5);
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		// ve truc tung
		graphics2d.draw(new Rectangle2D.Double(0, 0, CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20));
	}
}
