package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import utility.CommonConst;

@SuppressWarnings("serial")
public class DrawCircle extends JPanel {
	private double numberA;
	private double numberB;
	private double numberC;
	private Color color;

	public DrawCircle(double numberA, double numberB, double numberC, Color color) {
		setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 5);
		setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN / 20 - 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 30 - 5);
		this.numberA = numberA;
		this.numberB = numberB;
		this.numberC = numberC;
		this.color = color;
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(color);
		graphics2d.draw(new Ellipse2D.Double(numberA - Math.sqrt(numberC), numberB - Math.sqrt(numberC),
				2 * Math.sqrt(numberC), 2 * Math.sqrt(numberC)));
	}
}
