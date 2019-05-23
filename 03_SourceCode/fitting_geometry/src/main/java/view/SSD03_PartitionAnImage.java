package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import utility.CommonConst;

@SuppressWarnings("serial")
public class SSD03_PartitionAnImage extends JFrame {
	private JFrame frameMain;
	private Container containerMain;
	private JButton btnUpload;
	private JButton btnPartition;
	private JButton btnBack;

	public JFrame getFrameMain() {
		return frameMain;
	}

	public JButton getBtnUpload() {
		return btnUpload;
	}

	public JButton getBtnPartition() {
		return btnPartition;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public SSD03_PartitionAnImage() {
		initComponents();
		frameMain.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN + 6,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN + 29);
		frameMain.setLocationRelativeTo(null);
		frameMain.setResizable(false);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponents() {
		frameMain = new JFrame();
		containerMain = frameMain.getContentPane();
		containerMain.setLayout(null);

		// button upload image
		btnUpload = new JButton();
		btnUpload.setText(CommonConst.NAME_PARTITION_JFRAME.LOAD_IMAGE_BUTTON);
		btnUpload.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 20);
		btnUpload.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 13 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 23 / 60);

		// button partition image
		btnPartition = new JButton();
		btnPartition.setText(CommonConst.NAME_PARTITION_JFRAME.PARTITION_IMAGE_BUTTON);
		btnPartition.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 20);
		btnPartition.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 13 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 29 / 60);

		// button back
		btnBack = new JButton();
		btnBack.setText(CommonConst.BACK_BUTTON);
		btnBack.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN / 20);
		btnBack.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 13 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 37 / 60);

		containerMain.add(btnUpload);
		containerMain.add(btnPartition);
		containerMain.add(btnBack);
	}
}
