package misc;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Utilities {
	
	private static double windowWidth = -1;
	private static double windowHeight = -1;
	
	public static BufferedImage loadImage(String path, Object host) throws IOException {
		return ImageIO.read(new File(path) );
		
		//return ImageIO.read(host.getClass().getResource(path));
	}
	
	public static void setWindowHeight(double height, double width){
		windowHeight = height;
		windowWidth = width;
	}
	
	 
	public static boolean isInBox(MouseEvent e, RectangleBound rb){
		double x = (int) (((e.getX()/((double)windowWidth))) * 100.0);
		double y = (int) (((e.getY()/((double)windowHeight))) * 100.0);
		
		System.out.println("got: " + x + "," + y);
		System.out.println("Box: " + rb.getX() + "," + rb.getY() + "-"  + (rb.getX()+rb.getXLength()) + "," + (rb.getY() + rb.getYLength()));
		return (x >= rb.getX() && x<=rb.getX()+rb.getXLength() &&
				y>=rb.getY() && y <=rb.getY() + rb.getYLength());
	}
	/*
	
	/**
	 * returns true if the mouse event e is within a certain radius from a point. Scales accordingly
	 * @param e the mouse event
	 * @param center the center point
	 * @param radius the radius
	 * @return boolean as described
	 
	public static boolean isInCircle(MouseEvent e, misc.Point center,double radius){
		int x = (int) ((e.getX()-CANVAS_WIDTH_UNSCALED/2.0)/SCALE_FACTOR);
		int y = (int) ((e.getY() - CANVAS_HEIGHT_UNSCALED/2.0)/SCALE_FACTOR);
		
		double dx= x-center.x;
		double dy =y-center.y;
		
		return (Math.sqrt(dx*dx+dy*dy)<=radius);
		
	}*/
}
