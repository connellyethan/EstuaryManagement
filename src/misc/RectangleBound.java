package misc;

public class RectangleBound {
	double x1;
	double y1;
	double x2;
	double y2;
	double xLength;
	double yLength;
	
	
	public RectangleBound(double x1, double y1, double x2, double y2) {
		this.x1 = Math.min(x1,x2);
		this.y1 = Math.min(y1,y2);
		this.x2 = Math.max(x1,x2);
		this.y2 = Math.max(y1,y2);
		this.xLength = x2-x1;
		this.yLength = y2-y1;
	}
	
	public double getX1() {
		return x1;
	}
	public double getY1() {
		return y1;
	}
	public double getX2() {
		return x2;
	}
	public double getY2() {
		return y2;
	}
	public double getXLength() {
		return xLength;
	}
	public double getYLength() {
		return yLength;
	}

}
