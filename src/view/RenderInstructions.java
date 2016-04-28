package view;

public class RenderInstructions {

	
	private double transformX;
	private double transformY;
	private double rotation;
	private double scaleX;
	private double scaleY;
	private String imageName;
	private double heightPercentage;
	private double widthPercentage;
	

	public RenderInstructions(double transformX, double transformY, double rotation, double scaleX, double scaleY, String imageName, double heightPercentage, double widthPercentage) {
		this.transformX = transformX;
		this.transformY = transformY;
		this.rotation = rotation;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.imageName = imageName;
		this.heightPercentage = heightPercentage;
		this.widthPercentage = widthPercentage;
	}
	
	public RenderInstructions(double transformX, double transformY, String imageName, double heightPercentage, double widthPercentage) {
		this(transformX, transformY, 0,0,0, imageName, heightPercentage, widthPercentage);
	}

	public double getTransformX() {
		return transformX;
	}

	public double getTransformY() {
		return transformY;
	}

	public double getHeightPercentage() {
		return heightPercentage;
	}

	public double getWidthPercentage() {
		return widthPercentage;
	}

	public double getX() {
		return transformX;
	}

	public double getRotation() {
		return rotation;
	}

	public double getScaleX() {
		return scaleX;
	}

	public double getY() {
		return transformY;
	}

	public double getScaleY() {
		return scaleY;
	}

	public String getImageName() {
		return imageName;
	}

}









