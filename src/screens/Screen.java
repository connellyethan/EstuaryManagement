package screens;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import misc.Renderable;
import misc.Tickable;
import view.RenderInstructions;

public abstract class Screen implements Renderable, Tickable, MouseListener, MouseMotionListener {

	public String backgroundPath;
	
	
	public abstract void onTick();
	
	public abstract void initialize();
	
	
	public abstract ArrayList<RenderInstructions> render();
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseMoved(MouseEvent e);
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mouseEntered(MouseEvent e);
	public abstract void mouseExited(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	
	
	
	
}
