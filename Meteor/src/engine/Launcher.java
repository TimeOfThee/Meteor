package engine;
import graphics.Screen;

public class Launcher {
	public static final int screenSX=800,screenSY=600;
	
	public static void main(String[] srgs) {
		Screen game=new Screen("Title",screenSX,screenSY);
		game.start();
	}
}
