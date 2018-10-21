package engine;

public class Ray {
	
	private double direction,magnitude;
	
	/**Constructs a ray in 1 of 2 ways determined by coordinateMode
	 * 
	 * @param coordinateMode if this is true
	 * @param direction becomes the horizontal distance from the origin
	 * @param magnitude becomes the vertical distance from the origin
	 * @param coordinateMode anything else
	 * @param direction is the angle of the ray, 0 starting at the right and going clockwise
	 * @param magnitude is the length of the ray
	 * 
	 */
	public Ray(double direction,double magnitude,boolean coordinateMode) {
		if(coordinateMode) {
			this.direction=findAngle(0, 0, direction, magnitude);
			this.magnitude=Math.sqrt(direction*direction+magnitude*magnitude);
		}else {
			this.direction=direction;
			this.magnitude=magnitude;
		}
	}
	
	public double getDirection() {return this.direction;}
	public void setDirection(double to) {
		while(to<=0) {
			to+=360;
		}while(to>360) {
			to-=360;
		}
		this.direction=to;
	}
	public double getMagnitude() {return this.magnitude;}
	public void setMagnitude(double to) {
		if(to<0) {
			to=-to;
			this.magnitude=to;
			this.direction+=180;
			if(this.direction>360)this.direction-=360;
		}else {
			this.magnitude=to;
		}
	}
	public void setRay(double xstart,double ystart,double xend,double yend) {
		this.setDirection(findAngle(xstart,ystart,xend,yend));
		this.setMagnitude(findHypotenuse(xstart,ystart,xend,yend));
	}
	/** Uses findCosSin
	 * 
	 * @return the horizontal distance of the ray from the origin
	 */
	public double getX() {
		return findCosSin(direction, magnitude)[0];
	}
	/** Uses findCosSin
	 * 
	 * @return the vertical distance of the ray from the origin
	 */
	public double getY() {
		return findCosSin(direction, magnitude)[1];
	}
	/**This method adds a ray to this one, turning this one into the result
	 * 
	 * @param by Ray to be added to this one
	 */
	public void add(Ray by) {
		double x=findCosSin(direction, magnitude)[0]+findCosSin(by.getDirection(), by.getMagnitude())[0];
		double y=findCosSin(direction, magnitude)[1]+findCosSin(by.getDirection(), by.getMagnitude())[1];
		
		this.setDirection(findAngle(0, 0, (float)x, (float)y));
		this.magnitude=(float)Math.sqrt(x*x+y*y);
	}

	/**This method finds the point moved from the origin to a distance at an angle
	 * 
	 * @param ang angle starting from right and going clockwise
	 * @param dis distance from the origin
	 * @return a double[] of the horizontal distance (cosine) and the vertical distance (sine) from the origin
	 */
	public static double[] findCosSin(double ang,double dis) {
		double cos=Math.cos( Math.toRadians(ang) )*dis;
		double sin=Math.sin( Math.toRadians(ang) )*dis;
		return new double[] {cos,sin};
	}
	/**This method finds the angle of a line
	 * 
	 * @param xstart 
	 * @param ystart
	 * @param xend
	 * @param yend
	 * @return
	 */
	public static double findAngle(double xstart,double ystart,double xend,double yend) {
		double ang;
		if(xend-xstart!=0) {
			ang= Math.toDegrees( Math.atan((yend-ystart)/(xend-xstart)) );
			if(xend<xstart) {ang+=180;}
		}
		else {
			if(yend-ystart<0)ang=270;else ang=90;
		}
		return ang;
	}
	/**This method finds the length of a line
	 * 
	 * @param xs
	 * @param ys
	 * @param xe
	 * @param ye
	 * @return
	 */
	public static double findHypotenuse(double xstart,double ystart,double xend,double yend) {
		return Math.sqrt( (xend-xstart)*(xend-xstart)+(yend-ystart)*(yend-ystart) );
	}
}
