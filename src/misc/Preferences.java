package misc;

/**
 * Preferences stores the values of variables relating to rendering
 * @author Matts
 * */
public class Preferences {

	private static double aspectRatio = 1366.0 / 768.0;
	//private static double windowsInPixels
	private static int WINDOW_HEIGHT;
	private static int WINDOW_WIDTH;
	
	public static int getWINDOW_HEIGHT() {
		return WINDOW_HEIGHT;
	}
	public static void setWINDOW_HEIGHT(int wINDOW_HEIGHT) {
		WINDOW_HEIGHT = wINDOW_HEIGHT;
	}
	public static int getWINDOW_WIDTH() {
		return WINDOW_WIDTH;
	}
	public static void setWINDOW_WIDTH(int wINDOW_WIDTH) {
		WINDOW_WIDTH = wINDOW_WIDTH;
	}
	

}
