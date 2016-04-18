package misc;

import java.awt.Graphics2D;
import java.util.ArrayList;
import view.RenderInstructions;

/**
 * 
 * @author Matts
 * */
public interface Renderable {
	public ArrayList<RenderInstructions> getRenderInstuctions();

}
