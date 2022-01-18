import java.awt.Color;
import java.awt.Graphics2D;

public class TrafficLight {
	
	private Graphics2D g2;
	private int x1;
	private int y1;
	private int y2;
	private int width;
	private int height;
	private String smer;
	private Color [] colors;
	
	public TrafficLight(Graphics2D g2, int x1, int x2, int y1, int y2, String smer) {
		this.g2 = g2;
		this.x1 = x1;
		this.y1 = y1;
		this.y2 = y2;
		this.smer = smer;
		this.height = Math.abs(y1 - y2);
		this.width = Math.abs(x1 - x2);
		this.colors = new Color[3];
		colors[0] = Color.RED;
		colors[1] = Color.DARK_GRAY;
		colors[2] = Color.DARK_GRAY;	

	}
	
	public void go() {
		this.colors[0] = Color.DARK_GRAY;
		this.colors[1] = Color.DARK_GRAY;
		this.colors[2] = Color.GREEN;
		drawTL();
	}
	
	public void stop() {
		this.colors[0] = Color.RED;
		this.colors[1] = Color.DARK_GRAY;
		this.colors[2] = Color.DARK_GRAY;
		drawTL();
	}
	
	public void readyStop() {
		this.colors[0] = Color.RED;
		this.colors[1] = Color.YELLOW;
		this.colors[2] = Color.DARK_GRAY;
		drawTL();
	}
	
	public void ready() {
		this.colors[0] = Color.DARK_GRAY;
		this.colors[1] = Color.YELLOW;
		this.colors[2] = Color.DARK_GRAY;
		drawTL();
	}
	
	public void turnOff() {
		this.colors[0] = Color.DARK_GRAY;
		this.colors[1] = Color.DARK_GRAY;
		this.colors[2] = Color.DARK_GRAY;
		drawTL();
	}
	
	
	public void drawTL() {
		if(smer == "sever" || smer == "jih") {
			if(smer == "sever") {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y1, width, height);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y1, width/3, height);
				g2.setColor(colors[1]);
				g2.fillOval(x1 + width/3, y1, width/3, height);
				g2.setColor(colors[2]);
				g2.fillOval(x1 + 2 * width/3, y1, width/3, height);
			}else {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y1, width, height);
				g2.setColor(colors[2]);
				g2.fillOval(x1, y1, width/3, height);
				g2.setColor(colors[1]);
				g2.fillOval(x1 + width/3, y1, width/3, height);
				g2.setColor(colors[0]);
				g2.fillOval(x1 + 2 * width/3, y1, width/3, height);
			}
		}		
		if(smer == "vychod" || smer == "zapad") {
			if(smer == "vychod") {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y2, width, height);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y2, width, height/3);
				g2.setColor(colors[1]);
				g2.fillOval(x1, y2 + height/3, width,  height/3);
				g2.setColor(colors[2]);
				g2.fillOval(x1, y2 + 2 * height/3, width,  height/3);
			}else {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y2, width, height);
				g2.setColor(colors[2]);
				g2.fillOval(x1, y2, width, height/3);
				g2.setColor(colors[1]);
				g2.fillOval(x1, y2 + height/3, width,  height/3);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y2 + 2 * height/3, width,  height/3);
			}
		}
		
	}
	
}
