package entities;

import java.awt.Graphics;

import engine.Handler;

public abstract class Drone extends Ship{
	
	protected Mothership mother;
	protected float spd;
	
	public Drone(Handler ha,Mothership mother,float acc,float spdCap) {
		super(ha,mother.getLoc()[0],mother.getLoc()[1],mother.getColor(),acc,spdCap);
	}
	public abstract void update();
	public abstract void render(Graphics g,int cx, int cy);
}
