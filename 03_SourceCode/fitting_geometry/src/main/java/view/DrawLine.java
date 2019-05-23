package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import utility.CommonConst;

@SuppressWarnings("serial")
public class DrawLine extends JPanel {
	private double numberA;
	private double numberB;
	private Color color;

	public DrawLine(double numberA, double numberB, Color color) {
		setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16 + 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 + 5);
		setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN / 20 - 5,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 30 - 5);
		this.numberA = numberA;
		this.numberB = numberB;
		this.color = color;
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(color);
		graphics2d.draw(new Line2D.Double(0, numberB,
				(CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20 - numberB) / numberA,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 16 / 20));
	}
}
