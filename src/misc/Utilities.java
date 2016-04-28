package misc;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import model.ObsType;
import model.ToolType;

public class Utilities {

	private static double windowWidth = -1;
	private static double windowHeight = -1;
	public static final long NANOS_PER_SECOND = 1000000000;
	
	
	public static BufferedImage loadImage(String path, Object host) throws IOException {
		return ImageIO.read(new File(path));

		// return ImageIO.read(host.getClass().getResource(path));
	}

	public static void setWindowHeight(double height, double width) {
		windowHeight = height;
		windowWidth = width;
	}
	
	public static boolean hasCollided(RectangleBound hitbox1, RectangleBound hitbox2){
		double aLeft = hitbox1.getX1();
		double aRight = hitbox1.getX2();
		double aTop = hitbox1.getY1();
		double aBottom = hitbox1.getY2();

		double bLeft = hitbox2.getX1();
		double bRight = hitbox2.getX2();
		double bTop = hitbox2.getY1();
		double bBottom = hitbox2.getY2();

		return (aLeft < bRight && aRight > bLeft && aTop < bBottom && aBottom > bTop);
	}

	public static boolean isInBox(MouseEvent e, RectangleBound rb) {
		double x = (((e.getX() / ((double) windowWidth))) * 100.0);
		double y = (((e.getY() / ((double) windowHeight))) * 100.0);
		return isInBox(x, y, rb);
	}

	public static boolean isInBox(double x, double y, RectangleBound rb) {
		return ((x >= rb.getX1() && x <= rb.getX2()) && (y >= rb.getY1() && y <= rb.getY2()));
	}

	public static boolean typesAreCompatable(ObsType type2, ToolType type3) {
		if (type3 == ToolType.TRASHCAN && type2 == ObsType.TRASH) {
			return true;
		}
		if (type3 == ToolType.HAND && (type2 == ObsType.INVASIVE_PLANT || type2 == ObsType.INVASIVE_ANIMAL)) {
			return true;
		}
		if (type3 == ToolType.CLIPBOARD
				&& (type2 == ObsType.NON_INVASIVE_PLANT || type2 == ObsType.NON_INVASIVE_ANIMAL)) {
			return true;
		}
		if (type3 == ToolType.RESEARCHER
				&& (type2 == ObsType.NON_INVASIVE_PLANT || type2 == ObsType.NON_INVASIVE_ANIMAL)) {
			return true;
		}
		if (type3 == ToolType.VIAL && type2 == ObsType.POLLUTION) {
			return true;
		}

		return false;
	}

}
