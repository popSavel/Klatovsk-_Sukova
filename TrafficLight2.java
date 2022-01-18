import java.awt.Color;
import java.awt.Graphics2D;

public class TrafficLight2 {
	
	private Graphics2D g2;
	private int x1;
	private int y1;
	private int y2;
	private int width;
	private int height;
	private String smer;
	private Color [] colors;
	
	public TrafficLight2(Graphics2D g2, int x1, int x2, int y1, int y2, String smer) {
		this.g2 = g2;
		this.x1 = x1;
		this.y1 = y1;
		this.y2 = y2;
		this.smer = smer;
		this.height = Math.abs(y1 - y2);
		this.width = Math.abs(x1 - x2);
		this.colors = new Color[2];
		colors[0] = Color.RED;
		colors[1] = Color.DARK_GRAY;
	}
	
	public void go() {
		this.colors[0] = Color.DARK_GRAY;
		this.colors[1] = Color.GREEN;
		drawTL();
	}
	
	public void stop() {
		this.colors[0] = Color.RED;
		this.colors[1] = Color.DARK_GRAY;
		drawTL();
	}
	
	public void turnOff() {
		this.colors[0] = Color.DARK_GRAY;
		this.colors[1] = Color.DARK_GRAY;
		drawTL();
	}
	
	
	public void drawTL() {
		if(smer == "sever") {			
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y1, width, height);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y1, width/2, height);
				g2.setColor(colors[1]);
				g2.fillOval(x1 + width/2, y1, width/2, height);			
		}
		if(smer == "zapad" || smer == "vychod") {
			if(smer == "vychod") {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y2, width, height);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y2, width, height/2);
				g2.setColor(colors[1]);
				g2.fillOval(x1, y2 + height/2, width,  height/2);
			}else {
				g2.setColor(Color.BLACK);
				g2.fillRect(x1, y2, width, height);
				g2.setColor(colors[1]);
				g2.fillOval(x1, y2, width, height/2);
				g2.setColor(colors[0]);
				g2.fillOval(x1, y2 + height/2, width,  height/2);
			}
		}
		
	}
	
}
