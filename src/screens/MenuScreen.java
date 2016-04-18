package screens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import misc.RectangleBound;
import misc.Utilities;
import view.RenderInstructions;


/**
 * MenuScreen models the menuScreen of the game
 * @author Matts
 * */
public class MenuScreen extends Screen{
	private BufferedImage background;
	boolean flag;
	public boolean isOverStart;
	RectangleBound startButtonBounds;

	public MenuScreen(){
		flag = false;
		loadRes();
		System.out.println("MENUSCREEN CONSTRUCTOR");
		
		startButtonBounds = new RectangleBound(63,18,24,23);
	}
	
	/**
	 * loads the resources needs for this menus screen
	 */
	public void loadRes(){
	}
	
	@Override
	public ArrayList<RenderInstructions> render() {
		
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		
		RenderInstructions background;
		if(!flag){
			background = new RenderInstructions(0, 0, "res/menuScreen.png",100,100);
		}
		else{
			background = new RenderInstructions(0, 0, "res/background.png",100,100);
		}
		renderBatch.add(background);

		renderBatch.add(new RenderInstructions(startButtonBounds.getX(), startButtonBounds.getY(), "res/startButton.png", startButtonBounds.getXLength(), startButtonBounds.getYLength()));
//		g.drawImage(background, null, -800,0 );
		
		//System.out.println("Rendering menu");
		return renderBatch;
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Utilities.isInBox(e,startButtonBounds)){
			flag = true;
		}
		else{
			flag = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	//	flag = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//flag = false;
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}


}
