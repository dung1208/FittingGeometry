package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.SSD04_CreateSetPoint;
import logic.SSD05_LineFitting;
import logic.SSD07_CircleFitting;
import model.Point2D;
import view.DrawCircle;
import view.DrawLine;
import view.DrawListPoint;
import view.SSD01_MainScreen;
import view.SSD02_FittingSetPoint;

public class SSD02_FittingSetPointController {
	private SSD01_MainScreen mainJFrameView;
	private SSD02_FittingSetPoint fittingGeometryView;

	private List<Point2D> listPoint = new ArrayList<Point2D>();
	private SSD04_CreateSetPoint ssd04_CreateSetPoint = new SSD04_CreateSetPoint();
	private SSD05_LineFitting lineFitting = new SSD05_LineFitting();
	private SSD07_CircleFitting circleFitting = new SSD07_CircleFitting();

	public SSD02_FittingSetPointController(SSD01_MainScreen mainJFrameView, SSD02_FittingSetPoint fittingGeometryView) {
		this.mainJFrameView = mainJFrameView;
		this.fittingGeometryView = fittingGeometryView;
		initButton();
	}

	private void initButton() {
		// button back
		fittingGeometryView.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fittingGeometryView.getFrameMain().setVisible(false);
				mainJFrameView.getFrameMain().setVisible(true);
			}
		});

		// button line fitting
		fittingGeometryView.getBtnLineFitting().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fittingGeometryView.setCheckButtonIsSelect(1);
				fittingGeometryView.setLabelEquation("y = ax + b");
			}
		});

		// button eclipse fitting
		fittingGeometryView.getBtnCircleFitting().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fittingGeometryView.setCheckButtonIsSelect(2);
				fittingGeometryView.setLabelEquation("(a-x)^2 + (b-y)^2 = c");
			}
		});

		// button circle fitting
		fittingGeometryView.getBtnElipseFitting().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fittingGeometryView.setCheckButtonIsSelect(3);
				fittingGeometryView.setLabelEquation("x^2/a + y^2/b = c");
			}
		});

		// button LMS
		fittingGeometryView.getBtnLMS().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fittingGeometryView.getCheckButtonIsSelect() == 1) {
					List<Double> listOutput = lineFitting.fitLineByLMS(listPoint);
					fittingGeometryView.getPanelMain()
							.add(new DrawLine(listOutput.get(0), listOutput.get(1), Color.BLUE));

//					double errorNumber = CommonMethod.calculateErrorNumberLine(
//							Integer.valueOf(fittingGeometryView.getTextInputA().getText()),
//							Integer.valueOf(fittingGeometryView.getTextInputB().getText()), listOutput.get(0),
//							listOutput.get(1));

					fittingGeometryView.setLabelOutput(" y = " + listOutput.get(0) + "x + " + listOutput.get(1));
//					fittingGeometryView.setLabelErrorNumber("Error : " + String.valueOf(errorNumber) + "%");
					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();

				} else if (fittingGeometryView.getCheckButtonIsSelect() == 2) {
					List<Double> listOutput = circleFitting.fitCircleByLMS(listPoint);

					fittingGeometryView.getPanelMain()
							.add(new DrawCircle(listOutput.get(0), listOutput.get(1), listOutput.get(2), Color.BLUE));

					fittingGeometryView.setLabelOutput(
							" (x-" + listOutput.get(0) + ")^2 + (y-" + listOutput.get(1) + ")^2=" + listOutput.get(2));

					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();

				} else if (fittingGeometryView.getCheckButtonIsSelect() == 3) {

				}
			}
		});

		// button RS
		fittingGeometryView.getBtnRS().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fittingGeometryView.getCheckButtonIsSelect() == 1) {
					List<Double> listOutput = lineFitting.fitLineByRS(listPoint);

					fittingGeometryView.getPanelMain()
							.add(new DrawLine(listOutput.get(0), listOutput.get(1), Color.DARK_GRAY));

					fittingGeometryView.setLabelOutput(" y = " + listOutput.get(0) + "x + " + listOutput.get(1));

					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();
				} else if (fittingGeometryView.getCheckButtonIsSelect() == 2) {

					List<Double> listOutput = circleFitting.fitCircleByRS(listPoint);

					fittingGeometryView.getPanelMain().add(
							new DrawCircle(listOutput.get(0), listOutput.get(1), listOutput.get(2), Color.DARK_GRAY));

					fittingGeometryView.setLabelOutput(
							"(x-" + listOutput.get(0) + ")^2 + (y-" + listOutput.get(1) + ")^2=" + listOutput.get(2));

					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();

				} else if (fittingGeometryView.getCheckButtonIsSelect() == 3) {

				}
			}
		});

		// button HTF
		fittingGeometryView.getBtnHTF().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fittingGeometryView.getCheckButtonIsSelect() == 1) {

				} else if (fittingGeometryView.getCheckButtonIsSelect() == 2) {

				} else if (fittingGeometryView.getCheckButtonIsSelect() == 3) {

				}
			}
		});

		// button random point
		fittingGeometryView.getBtnRandomPoint().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fittingGeometryView.getCheckButtonIsSelect() == 1) {

					double numberA = Double.parseDouble(fittingGeometryView.getTextInputA().getText());
					double numberB = Double.parseDouble(fittingGeometryView.getTextInputB().getText());
					int countPoint = Integer.parseInt(fittingGeometryView.getTextCountPoint().getText());
					listPoint.clear();
					listPoint.addAll(ssd04_CreateSetPoint.createListPointLine(numberA, numberB, countPoint));
					fittingGeometryView.getPanelMain().add(new DrawListPoint(listPoint), 1);
					fittingGeometryView.getPanelMain().add(new DrawLine(numberA, numberB, Color.RED));

					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();
				} else if (fittingGeometryView.getCheckButtonIsSelect() == 2) {

					double numberA = Double.parseDouble(fittingGeometryView.getTextInputA().getText());
					double numberB = Double.parseDouble(fittingGeometryView.getTextInputB().getText());
					double numberC = Double.parseDouble(fittingGeometryView.getTextInputC().getText());
					int countPoint = Integer.parseInt(fittingGeometryView.getTextCountPoint().getText());
					listPoint.clear();
					listPoint.addAll(ssd04_CreateSetPoint.createListPointCircle(numberA, numberB, numberC, countPoint));
					fittingGeometryView.getPanelMain().add(new DrawListPoint(listPoint), 1);
					fittingGeometryView.getPanelMain().add(new DrawCircle(numberA, numberB, numberC, Color.RED));
					fittingGeometryView.getPanelMain().revalidate();
					fittingGeometryView.getPanelMain().repaint();
				}
			}
		});

		// button reset screen
		fittingGeometryView.getBtnResetScreen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// reset main screen
				int countComponent = fittingGeometryView.getPanelMain().getComponentCount();
				for (int i = countComponent - 1; i > 0; i--) {
					fittingGeometryView.getPanelMain().remove(i);
				}
				fittingGeometryView.getPanelMain().revalidate();
				fittingGeometryView.getPanelMain().repaint();
				fittingGeometryView.getTextInputA().setText("");
				fittingGeometryView.getTextInputB().setText("");
				fittingGeometryView.getTextInputC().setText("");
				fittingGeometryView.setLabelOutput("");
			}
		});
	}
}
