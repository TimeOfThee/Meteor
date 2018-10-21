package engine;

public class Handler {

	private Main main;
	
	public Handler(Main main) {
		this.main=main;
	}
	
	public Main getMain() {return main;}
	public KeyManager getKM() {return main.getKM();}
	public MouseManager getMM() {return main.getMM();}
	
	//math
	public static double[] findCosSin2(double xShift,double yShift) {
		return findCosSin(findAngle(0,0,xShift,yShift),findHypotenuse(0,0,xShift,yShift));
	}
	public static double[] findCosSin(double ang,double dis) {
		return Ray.findCosSin(ang, dis);
	}
	public static double findAngle(double xstart,double ystart,double xend,double yend) {
		return Ray.findAngle(xstart, ystart, xend, yend);
	}
	public static double findHypotenuse(double xstart,double ystart,double xend,double yend) {
		return Ray.findHypotenuse(xstart, ystart, xend, yend);
	}
	
}
