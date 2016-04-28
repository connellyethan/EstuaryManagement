package screens;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import misc.Preferences;
import misc.RectangleBound;
import misc.Utilities;
import view.RenderInstructions;


/**
 * MenuScreen models the menuScreen of the game
 * @author Matts
 * */
public class MenuScreen extends Controller{
	boolean flag;
	public boolean isOverStart;
	RectangleBound startButtonBounds;

	public MenuScreen(){
		flag = false;
		switchScreen = false;
		loadRes();
		System.out.println("MENUSCREEN CONSTRUCTOR");
		
		startButtonBounds = new RectangleBound(63,18,87,41);
	}
	
	/**
	 * loads the resources needs for this menus screen
	 */
	public void loadRes(){
	}
	
	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		
		RenderInstructions background = new RenderInstructions(0, 0, "res/menuScreen.png",100,100);
		renderBatch.add(background);

		RenderInstructions startButton = new RenderInstructions(startButtonBounds.getX1(), startButtonBounds.getY1(), "res/startButton.png", startButtonBounds.getXLength(), startButtonBounds.getYLength());
		renderBatch.add(startButton);

		return renderBatch;
		
	}

	
	@Override
	public void onTick(long deltaNs) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		
		System.out.println("original x: " + x);
		
		x = (x/Preferences.getWINDOW_WIDTH()) * 100.0;
		y = (y/Preferences.getWINDOW_HEIGHT()) * 100.0;
		
		System.out.println("edited x: " + x);
		if(Utilities.isInBox((int) x, (int) y ,startButtonBounds)){
			switchScreen = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void initialize() {
	}

	
}
