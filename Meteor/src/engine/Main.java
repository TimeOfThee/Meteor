package engine;

import java.awt.Graphics;

import graphics.Camera;

public class Main {
	
	private KeyManager kM;
	private MouseManager mM;
	private Handler ha;
	private Camera cam;
	
	public Main(KeyManager km,MouseManager mm) {
		this.kM=km;
		this.mM=mm;
		this.ha=new Handler(this);
		this.cam=new Camera(ha);
	}
	
	public void update() {
		kM.update();
		cam.update();
	}
	public void render(Graphics g) {
		
	}
	public KeyManager getKM() {return this.kM;}
	public MouseManager getMM() {return this.mM;}
}
