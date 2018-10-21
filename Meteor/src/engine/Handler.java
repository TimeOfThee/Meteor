package engine;

public class Handler {

	private Main main;
	
	public Handler(Main main) {
		this.main=main;
	}
	
	public Main getMain() {return main;}
	public KeyManager getKM() {return main.getKM();}
	public MouseManager getMM() {return main.getMM();}
	
}
