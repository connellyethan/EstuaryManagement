package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import misc.Renderable;
import screens.Screen;

public class PreAlphaView extends Canvas {

	private BufferStrategy bs;
	private ResourcePool resourcePool;
	double windowHeight;
	double windowWidth;


	public PreAlphaView(){
		resourcePool = new ResourcePool();
		
	}
	
	public void render(Screen currentScreen) {
		windowHeight = getPreferredSize().getHeight();
		windowWidth = getPreferredSize().getWidth();
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		////// RENDERING LOOP ///////
		ArrayList<RenderInstructions> renderBatch = currentScreen.render();
		for (RenderInstructions currentInstruction : renderBatch) {

			//Sets up values for current render
			int translateX = (int) ((currentInstruction.getX()/100.0) * windowWidth);
			int translateY = (int) ((currentInstruction.getY()/100.0) * windowHeight);
			double rotation = currentInstruction.getRotation();
			double scaleX = currentInstruction.getScaleX();
			double scaleY = currentInstruction.getScaleY();
			String imageName = currentInstruction.getImageName();
			BufferedImage sprite = resourcePool.getImage(imageName);
			double heightPercentage = currentInstruction.getHeightPercentage();
			double widthPercentage = currentInstruction.getWidthPercentage();
			boolean rotateFlag = (rotation != 0);
			boolean scaleFlag = ((scaleX != 0) || (scaleY != 0));
			
			//Translate, rotate, and scale if needed
			g.translate(translateX, translateY);
			if(rotateFlag){
				g.rotate(rotation);
			}
			if(scaleFlag){
				g.scale(scaleX, scaleY);
			}
			
			//TODO map this better
			g.drawImage(sprite,0,0,(int)(windowWidth * (widthPercentage/100)),(int)(windowHeight * (heightPercentage/100)),null,null);
 			
			//Reverse translate, rotate, and scale if needed
			if(scaleFlag){
				g.scale(-scaleX, -scaleY);
			}
			if(rotateFlag){
				g.rotate(-rotation);
			}
			g.translate(-translateX, -translateY);			
		}
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer		
	}
	
	
}
