package entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.Handler;
import engine.Ray;

public abstract class Ship extends Entity{

	protected float[] target;
	protected Ray motion=new Ray(0,0,false);
	protected float spd,acc,spdCap;
	
	protected Color color;
	
	public Ship(Handler ha,float x, float y,Color color,float acc,float spdCap) {
		super(ha,x,y);
		this.color=color;
		this.target=new float[] {loc[0],loc[1]};
		this.spd=0;
		this.acc=acc;
		this.spdCap=spdCap;
	}
	protected void move() {
		motion.setRay(loc[0], loc[1], target[0], target[1]);
		double dis= Math.sqrt( (target[0]-loc[0])*(target[0]-loc[0])+(target[1]-loc[1])*(target[1]-loc[1]) );
		
		if(dis>spdCap) {
			if(spd<spdCap) {
				spd+=acc;
				if(spd>spdCap)spd=spdCap;
			}
		}else if(dis>acc){
			if(spd>acc) {
				spd-=acc;
				if(spd<acc)spd=acc;
			}else if(spd<acc) {
				spd+=acc;
				if(spd>acc)spd=acc;
			}
		}else {
			spd=0;
			loc[0]=target[0];
			loc[1]=target[1];
		}
		motion.setMagnitude(spd);
		move(motion);
	}
	
	public abstract void update();
	public abstract void render(Graphics g,int cx, int cy);
}
