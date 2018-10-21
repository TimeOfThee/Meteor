package entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.Handler;
import engine.Ray;

public abstract class Entity {

	protected Handler ha;
	protected float[] loc;
	
	public Entity(Handler ha) {
		this.ha=ha;
		this.loc=new float[]{0,0};
	}
	public Entity(Handler ha,float x,float y) {
		this.ha=ha;
		this.loc=new float[]{x,y};
	}
	
	public abstract void update();
	public abstract void render(Graphics g,int cx, int cy);
	public void move(float x,float y) {
		this.loc[0]+=x;
		this.loc[1]+=y;
	}
	public void move(Ray ray) {
		this.loc[0]+=ray.getX();
		this.loc[1]+=ray.getY();
	}
	
	public void debugRender(Graphics g,Color color,int cx, int cy) {
		g.setColor(color);
		g.drawOval((int)loc[0]-cx-3, (int)loc[1]-cy-3, 6, 6);
	}
	
	public float[] getLoc() {return this.loc;}
}
