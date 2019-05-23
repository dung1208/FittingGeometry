package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import utility.CommonConst;

@SuppressWarnings("serial")
public class SSD02_FittingSetPoint extends JFrame {

	private JFrame frameMain;
	private Container containerMain;
	private JPanel panelMain;

	private JPanel panelAlgorithm;
	private JPanel panelListButton;
	private JPanel panelInputSource;

	private JButton btnLineFitting;
	private JButton btnElipseFitting;
	private JButton btnCircleFitting;
	private JButton btnResetScreen;
	private JButton btnBack;
	private JButton btnRandomPoint;

	private JButton btnLMS;
	private JButton btnRS;
	private JButton btnHTF;

	private JTextField textInputA;
	private JTextField textInputB;
	private JTextField textInputC;
	private JTextField textCountPoint;

	private JLabel labelEquation;
	private JLabel labelOutput;
	private JLabel labelErrorNumber;

	private int checkButtonIsSelect;

	public JFrame getFrameMain() {
		return frameMain;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public void setLabelErrorNumber(String text) {
		labelErrorNumber.setText(text);
	}

	public void setLabelEquation(String textLabel) {
		labelEquation.setText(textLabel);
	}

	public void setLabelOutput(String outputNumber) {
		labelOutput.setText(outputNumber);
	}

	public JButton getBtnLineFitting() {
		return btnLineFitting;
	}

	public JButton getBtnElipseFitting() {
		return btnElipseFitting;
	}

	public JButton getBtnCircleFitting() {
		return btnCircleFitting;
	}

	public JButton getBtnResetScreen() {
		return btnResetScreen;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnRandomPoint() {
		return btnRandomPoint;
	}

	public JButton getBtnLMS() {
		return btnLMS;
	}

	public JButton getBtnRS() {
		return btnRS;
	}

	public JButton getBtnHTF() {
		return btnHTF;
	}

	public JTextField getTextInputA() {
		return textInputA;
	}

	public JTextField getTextInputB() {
		return textInputB;
	}

	public JTextField getTextInputC() {
		return textInputC;
	}

	public JTextField getTextCountPoint() {
		return textCountPoint;
	}

	public int getCheckButtonIsSelect() {
		return checkButtonIsSelect;
	}

	public void setCheckButtonIsSelect(int checkButtonIsSelect) {
		this.checkButtonIsSelect = checkButtonIsSelect;
	}

	public SSD02_FittingSetPoint() {
		frameMain = new JFrame();
		frameMain.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN + 6,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN + 29);
		frameMain.setResizable(true);
		frameMain.setLocationRelativeTo(null);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		containerMain = frameMain.getContentPane();
		containerMain.setLayout(null);

		panelMain = new JPanel();
		panelListButton = new JPanel();
		panelAlgorithm = new JPanel();
		panelInputSource = new JPanel();
		labelEquation = new JLabel();
		labelOutput = new JLabel();
		labelErrorNumber = new JLabel();

		containerMain.add(panelMain);
		containerMain.add(panelListButton);
		containerMain.add(panelInputSource);
		containerMain.add(panelAlgorithm);
		containerMain.add(labelEquation);
		containerMain.add(labelOutput);
		containerMain.add(labelErrorNumber);
		// partition screen application
		sperateScreen();
		initComponent();
	}

	private void sperateScreen() {
		// visible equation of line, eclipse, circle
		labelEquation.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 3 / 20);
		labelEquation.setLocation(0, 0);
		// input the a,b,c
		panelInputSource.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 5 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 3 / 20);
		panelInputSource.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16, 0);
		// algorithm fit
		panelAlgorithm.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 4 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 3 / 20);
		panelAlgorithm.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 8 / 16, 0);
		// output the a,b,c
		labelOutput.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 4 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 2 / 20);
		labelOutput.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16, 0);

		// output error number
		labelErrorNumber.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 4 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 1 / 20);
		labelErrorNumber.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 12 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 2 / 20);
		// panel list main button
		panelListButton.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 17 / 20);
		panelListButton.setLocation(0, CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 3 / 20);
		// main screen
		panelMain.setSize(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 13 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 17 / 20);
		panelMain.setLocation(CommonConst.SIZE_COMPONENT.WIDTH_MEMBER_SCREEN * 3 / 16,
				CommonConst.SIZE_COMPONENT.HEIGHT_MEMBER_SCREEN * 3 / 20);
	}

	private void initComponent() {
		createLabelEquation(labelEquation);
		createPanelInputSource(panelInputSource);
		createPanelAlgorithm(panelAlgorithm);
		createPanelListButton(panelListButton);
		createPanelMain(panelMain);
		createLabelOutput(labelOutput);
		createLabelErrorNumber(labelErrorNumber);
	}

	/**
	 * panel visible equation
	 * 
	 * @param panelEquation
	 */
	private void createLabelEquation(JLabel labelEquation) {
		String textEquation = "Hello Word";
		labelEquation.setText(textEquation);
		labelEquation.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * panel enter data input
	 * 
	 * @param panelInputSource
	 */
	private void createPanelInputSource(JPanel panelInputSource) {
		panelInputSource.setLayout(new BorderLayout());

		JLabel labelInputSource = new JLabel("Input the data ");
		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.add(labelInputSource);

		JLabel numberA = new JLabel("a");
		JLabel numberB = new JLabel("b");
		JLabel numberC = new JLabel("c");
		JLabel countPoint = new JLabel("Size");

		textInputA = new JTextField();
		textInputB = new JTextField();
		textInputC = new JTextField();
		textCountPoint = new JTextField();

		JPanel centerPanel = new JPanel(new GridLayout(2, 4));

		centerPanel.add(numberA);
		centerPanel.add(numberB);
		centerPanel.add(numberC);
		centerPanel.add(countPoint);
		centerPanel.add(textInputA);
		centerPanel.add(textInputB);
		centerPanel.add(textInputC);
		centerPanel.add(textCountPoint);

		btnRandomPoint = new JButton("Random Point");

		panelInputSource.add(topPanel, BorderLayout.NORTH);
		panelInputSource.add(centerPanel, BorderLayout.CENTER);
		panelInputSource.add(btnRandomPoint, BorderLayout.SOUTH);
	}

	/**
	 * panel for fit by algorithm
	 * 
	 * @param panelAlgorithm
	 */
	private void createPanelAlgorithm(JPanel panelAlgorithm) {
		panelAlgorithm.setLayout(new GridLayout(3, 1));
		// button fit by least mean squares
		btnLMS = new JButton(CommonConst.NAME_FITTING_JFRAME.FIT_BY_LMS);
		// button fit by ranSac
		btnRS = new JButton();
		btnRS.setText(CommonConst.NAME_FITTING_JFRAME.FIT_BY_RANSAC);
		// button fit houghTranform
		btnHTF = new JButton(CommonConst.NAME_FITTING_JFRAME.FIT_BY_HTF);
		panelAlgorithm.add(btnLMS);
		panelAlgorithm.add(btnRS);
		panelAlgorithm.add(btnHTF);
	}

	/**
	 * label output result
	 * 
	 * @param labelOutput
	 */

	private void createLabelOutput(JLabel labelOutput) {
		labelOutput.setHorizontalAlignment(SwingConstants.LEFT);
		Font font = new Font("Tahoma", Font.ITALIC, 10);
		labelOutput.setFont(font);
	}

	/**
	 * label output error number
	 * 
	 * @param labelErrorNumber
	 */
	private void createLabelErrorNumber(JLabel labelErrorNumber) {
		labelOutput.setHorizontalAlignment(SwingConstants.LEFT);
		Font font = new Font("Tahoma", Font.ITALIC, 10);
		labelOutput.setFont(font);
	}

	/**
	 * panel contains list main button
	 * 
	 * @param panelListButton
	 */
	private void createPanelListButton(JPanel panelListButton) {
		panelListButton.setLayout(new GridLayout(10, 1, 20, 20));
		// button line fitting
		btnLineFitting = new JButton(CommonConst.NAME_FITTING_JFRAME.LINE_BUTTON);
		// button eclipse fitting
		btnElipseFitting = new JButton(CommonConst.NAME_FITTING_JFRAME.ELIPSE_BUTTON);
		// button circle fitting
		btnCircleFitting = new JButton(CommonConst.NAME_FITTING_JFRAME.CIRCLE_BUTTON);
		// button reset screen
		btnResetScreen = new JButton(CommonConst.NAME_FITTING_JFRAME.RESET_DISPLAY);
		// button back
		btnBack = new JButton(CommonConst.BACK_BUTTON);
		panelListButton.add(btnLineFitting);
		panelListButton.add(btnCircleFitting);
		panelListButton.add(btnElipseFitting);
		panelListButton.add(btnResetScreen);
		panelListButton.add(btnBack);
	}

	/**
	 * panel draw list points
	 * 
	 * @param panelMain
	 */
	private void createPanelMain(JPanel panelMain) {
		panelMain.setLayout(null);
		panelMain.add(new DrawCoordinateAxis(), 0);
	}
}
