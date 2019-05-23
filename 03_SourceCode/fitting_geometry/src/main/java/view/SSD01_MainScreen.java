
package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utility.CommonConst;

@SuppressWarnings("serial")
public class SSD01_MainScreen extends JFrame {
	private JFrame frameMain;
	private Container containerMain;

	private JLabel labelNameApp;

	private JButton btnFitGeometry;
	private JButton btnPartition;
	private JButton btnExit;

	private JLabel labelInformation;

	public JFrame getFrameMain() {
		return frameMain;
	}

	public JButton getBtnFitGeometry() {
		return btnFitGeometry;
	}

	public JButton getBtnPartition() {
		return btnPartition;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public SSD01_MainScreen() {
		initComponents();
		// ten, kich thuoc va vi tri cua man hinh chinh
		frameMain.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN + 6,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN + 29);
		frameMain.setLocationRelativeTo(null);
		frameMain.setResizable(false);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initComponents() {
		frameMain = new JFrame();
		frameMain.setVisible(true);

		containerMain = frameMain.getContentPane();
		containerMain.setLayout(null);

		// label and image of application
		labelNameApp = new JLabel();
		labelNameApp.setText(CommonConst.NAME_MAIN_JFRAME.TITLE);
		labelNameApp.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN / 4);
		labelNameApp.setLocation(0, 0);
		labelNameApp.setHorizontalAlignment(SwingConstants.CENTER);

		// button fit geometry
		btnFitGeometry = new JButton();
		btnFitGeometry.setText(CommonConst.NAME_MAIN_JFRAME.FITGEOMETRY_BUTTON);
		btnFitGeometry.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN / 2,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN / 10);
		btnFitGeometry.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN / 4,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN * 7 / 20);

		// button partition
		btnPartition = new JButton();
		btnPartition.setText(CommonConst.NAME_MAIN_JFRAME.PARTITTION_BUTTUON);
		btnPartition.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN / 2,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN / 10);
		btnPartition.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN / 4,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN * 11 / 20);

		// button exit
		btnExit = new JButton();
		btnExit.setText(CommonConst.NAME_MAIN_JFRAME.EXIT_BUTTON);
		btnExit.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN / 4,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN / 15);
		btnExit.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN * 3 / 8,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN * 17 / 20);

		// label information about application
		labelInformation = new JLabel();
		labelInformation.setText("Liên hệ : Nhom3ksclcthcnk61@gmail.com");
		labelInformation.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MAIN_SCREEN,
				CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN / 8);
		labelInformation.setLocation(0, CommonConst.SIZE_COMPONENT.HEIGHT_MAIN_SCREEN * 7 / 8);
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setVerticalAlignment(SwingConstants.BOTTOM);

		containerMain.add(labelNameApp);
		containerMain.add(btnFitGeometry);
		containerMain.add(btnPartition);
		containerMain.add(btnExit);
		containerMain.add(labelInformation);
	}
}
