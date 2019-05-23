package main;

import controller.SSD02_FittingSetPointController;
import controller.SSD01_MainScreenController;
import controller.SSD03_PartitionAnImageController;
import view.SSD02_FittingSetPoint;
import view.SSD01_MainScreen;
import view.SSD03_PartitionAnImage;

public class Main {
	public static void main(String[] args) {
		SSD01_MainScreen mainJFrameView = new SSD01_MainScreen();
		SSD02_FittingSetPoint fittingGeometryView = new SSD02_FittingSetPoint();
		SSD03_PartitionAnImage partitionImageView = new SSD03_PartitionAnImage();
		new SSD01_MainScreenController(mainJFrameView, fittingGeometryView, partitionImageView);
		new SSD03_PartitionAnImageController(mainJFrameView, partitionImageView);
		new SSD02_FittingSetPointController(mainJFrameView, fittingGeometryView);
	}
}
