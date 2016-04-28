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
		//Menu Screen
		addResource("res/menuScreen.png");
		addResource("res/startButton.png");
		
		//Main Game
		addResource("res/background.png");
	
		
		//Tools
		addResource("res/toolbox.png");
		addResource("res/trashcan.png");
		addResource("res/hand.png");
		addResource("res/researcher.png");
		addResource("res/clipboard.png");
		addResource("res/vial.png");

		//Enemies
		addResource("res/trash.png");
		addResource("res/invasivePlant.png");
		addResource("res/nonInvasivePlant.png");
		addResource("res/invasiveAnimal.png");
		addResource("res/nonInvasiveAnimal.png");
		addResource("res/pollution.png");

		//End Game
		addResource("res/endScreen.png");
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