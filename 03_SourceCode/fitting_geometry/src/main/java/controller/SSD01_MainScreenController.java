package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SSD02_FittingSetPoint;
import view.SSD01_MainScreen;
import view.SSD03_PartitionAnImage;

public class SSD01_MainScreenController {

	private SSD01_MainScreen mainJFrameView;
	private SSD02_FittingSetPoint fittingGeometryView;
	private SSD03_PartitionAnImage partitionImageView;

	public SSD01_MainScreenController(SSD01_MainScreen mainJFrameView, SSD02_FittingSetPoint fittingGeometryView,
			SSD03_PartitionAnImage partitionImageView) {
		this.mainJFrameView = mainJFrameView;
		this.fittingGeometryView = fittingGeometryView;
		this.partitionImageView = partitionImageView;
		initButton();
	}

	private void initButton() {
		// button fit geometry
		mainJFrameView.getBtnFitGeometry().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainJFrameView.getFrameMain().setVisible(false);
				fittingGeometryView.getFrameMain().setVisible(true);
			}
		});

		// button partition image
		mainJFrameView.getBtnPartition().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainJFrameView.getFrameMain().setVisible(false);
				partitionImageView.getFrameMain().setVisible(true);
			}
		});

		// button exit
		mainJFrameView.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}
}
