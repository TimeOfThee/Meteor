package engine;


import java.awt.Color;
import java.awt.Graphics;

public class Main {
	
	private KeyManager kM;
	private MouseManager mM;
	private Handler ha;
	
	public Main(KeyManager km,MouseManager mm) {
		this.kM=km;
		this.mM=mm;
		this.ha=new Handler(this);
	}
	
	public void update() {
		kM.update();
	}
	public void render(Graphics g) {
		
	}
	public KeyManager getKM() {return this.kM;}
	public MouseManager getMM() {return this.mM;}
}
