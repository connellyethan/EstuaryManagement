package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import misc.Utilities;

public class ResourcePool {
	
	HashMap<String, BufferedImage> resourceMap;
	
	public ResourcePool(){
		resourceMap = new HashMap<String, BufferedImage>();
		initializeResources();
	}
	
	public void initializeResources(){
		//TODO initialize resources
		addResource("res/menuScreen.png");
		addResource("res/enemy1.png");
		addResource("res/background.png");
		addResource("res/startButton.png");
		addResource("res/endScreen.png");
		addResource("res/toolbox.png");
	}
	
	private void addResource(String imagePath){
		BufferedImage newResource = null;
		try {
			newResource = Utilities.loadImage(imagePath, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		resourceMap.put(imagePath, newResource);
	}
	
	public BufferedImage getImage(String imageName){
		return resourceMap.get(imageName);
	}
}