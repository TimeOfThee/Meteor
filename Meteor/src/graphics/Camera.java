package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import engine.Handler;
import engine.Launcher;

public class Camera {

	private Handler ha;
	private float cx,cy,spd=4;
	private ArrayList<int[]> focus,pile;
	private boolean snap=false;
	
	public Camera(Handler ha) {
		this.ha=ha;
		this.focus=new ArrayList<int[]>();
		this.pile=new ArrayList<int[]>();
		this.cx=0;this.cy=0;
	}
	public void update() {
		focus.clear();
		focus.addAll(pile);
		pile.clear();
		
		if(spd<=0)spd=1;
		
		float[]target=findFocus();
		
		if(snap) {
			cx=target[0];cy=target[1];
			snap=false;
		}else {
			if( Math.sqrt( (double)( (target[0]-cx)*(target[0]-cx)+(target[1]-cy)*(target[1]-cy) ) )<=1){
				cx=target[0];cy=target[1];
			}else {
				cx+=(target[0]-cx)/spd;
				cy+=(target[1]-cy)/spd;
			}
		}
		
	}
	public void render(Graphics g) {
		g.setColor(new Color(200,50,50));
		g.drawRect(0, 0, Launcher.screenSX-1, Launcher.screenSY-1);
		g.drawRect(2, 2, Launcher.screenSX-5, Launcher.screenSY-5);
		
		float[] target=findFocus();
		int size=10;
		g.drawOval( (int)(target[0]+(Launcher.screenSX/2)-cx-(size/2)), (int)(target[1]+(Launcher.screenSY/2)-cy-(size/2)), size, size);
		g.drawLine( (int)(target[0]+(Launcher.screenSX/2)-cx), (int)(target[1]+(Launcher.screenSY/2)-cy), Launcher.screenSX/2, Launcher.screenSY/2);
		g.setColor(new Color(200,50,150));
		for(int[] d:focus) {
			g.drawOval((int)(d[0]-(size/2)-cx), (int)(d[1]-(size/2)-cy), size, size);
		}
	}
	
	private float[] findFocus() {
		float tx=0,ty=0;
		if(!focus.isEmpty()) {
			for(int[] foc:focus) {
				tx+=foc[0];
				ty+=foc[1];
			}
			tx=tx/focus.size();
			ty=ty/focus.size();
		}else {
			tx=cx;
			ty=cy;
		}
		tx-=Launcher.screenSX/2;
		ty-=Launcher.screenSY/2;
		
		return new float[] {tx,ty};
	}
	
	public void snap() {
		snap=true;
	}
	public void focus(int x,int y) {this.pile.add(new int[] {x,y});}
	public float[] getCamLoc() {return new float[] {cx,cy};}
}
