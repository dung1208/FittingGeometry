package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SSD01_MainScreen;
import view.SSD03_PartitionAnImage;

public class SSD03_PartitionAnImageController {

	private SSD01_MainScreen mainJFrameView;
	private SSD03_PartitionAnImage partitionImageView;

	public SSD03_PartitionAnImageController(SSD01_MainScreen mainJFrameView, SSD03_PartitionAnImage partitionImageView) {
		this.mainJFrameView = mainJFrameView;
		this.partitionImageView = partitionImageView;
		initButton();
	}

	private void initButton() {
		// button back
		partitionImageView.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				partitionImageView.getFrameMain().setVisible(false);
				mainJFrameView.getFrameMain().setVisible(true);
			}
		});
	}

}
