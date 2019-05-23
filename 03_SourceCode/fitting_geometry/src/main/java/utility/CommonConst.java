package utility;

public class CommonConst {

	public static String BACK_BUTTON = "Back";
	public static double EPSILON_NUMBER = 100.0;
	public static double REGION_ERROR_NUMBER = 10.0;
	public static double REGION_ERROR_NUMBER_2 = 30.0;
	public static double RADIUS_POINT = 0.8;
	public static double RATIO_NOISY_POINT = 0.01;
	public static double REGION_EPSILON = 30.0;

	// chua ten cua cac nut cua man hinh chinh
	public static class NAME_MAIN_JFRAME {
		public static String TITLE = "Nhom 3";

		public static String FITGEOMETRY_BUTTON = "Fitting Geometry";

		public static String PARTITTION_BUTTUON = "Partition An Image";

		public static String EXIT_BUTTON = "Exit";

	}

	// chua ten cua cac nut cua man hinh fit cac duong hinh hoc
	public static class NAME_FITTING_JFRAME {
		public static String TITLE = "Fitting Geometry";

		public static String LINE_BUTTON = "Line Fitting";

		public static String ELIPSE_BUTTON = "Elipse Fitting";

		public static String CIRCLE_BUTTON = "Circle Fitting";

		public static String RANDOM_POINT = "Creat a set point";

		public static String RESET_DISPLAY = "Reset display";

		public static String FIT_BY_LMS = "Least Mean Squares";
		public static String FIT_BY_RANSAC = "Ransac";
		public static String FIT_BY_HTF = "Hough Tranform";
	}

	// chua ten cua cac nut cua man hinh phan vung buc anh
	public static class NAME_PARTITION_JFRAME {
		public static String TITLE = "Partition Image";

		public static String LOAD_IMAGE_BUTTON = "Load image";

		public static String PARTITION_IMAGE_BUTTON = "Partition this image";
	}

	// chua kich thuoc cua cac nut
	public static class SIZE_COMPONENT {
		public static int WIDTH_MAIN_SCREEN = 400;
		public static int HEIGHT_MAIN_SCREEN = 300;

		public static int WIDTH_MEMBER_SCREEN = 800;
		public static int HEIGHT_MEMBER_SCREEN = 600;
	}
}
