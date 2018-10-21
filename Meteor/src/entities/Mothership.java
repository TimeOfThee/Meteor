package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import engine.Handler;

public class Mothership extends Ship{

	private ArrayList<Drone> drones;
	private int storage;
	
	public Mothership(Handler ha,float x, float y,Color color,int drones) {
		super(ha,x,y,color,1,3);
		this.drones=new ArrayList<Drone>();
		for(int a=0;a<drones;a++) {
			//create drone
		}
		this.storage=0;
	}

	@Override
	public void update() {
		move();
		//deploy
		for(Drone d:drones) {
			//update
		}
	}

	@Override
	public void render(Graphics g, int cx, int cy) {
		for(Drone d:drones) {
			//render
		}
		
		g.setColor(color);
		g.fillRect((int)(loc[0]-40)-cx, (int)(loc[1]-40)-cy, 80, 80);
		g.setColor(color.darker());
		g.fillRect((int)(loc[0]-35)-cx, (int)(loc[1]-7)-cy, 70, 14);
		g.setColor(Color.white);
		g.drawString(Integer.toString(storage), (int)(loc[0]-34)-cx, (int)(loc[1]+5)-cy);
	}
	
	public void store(int add) {this.storage+=add;}
	public float[] getTarget() {return this.target;}
	public void setTarget(float x,float y) {this.target=new float[] {x,y};}
	public Color getColor() {return this.color;}
	
}
