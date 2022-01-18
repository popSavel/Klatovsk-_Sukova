import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class DrawingPanel extends JPanel {
	
	private int w;
	private int h;
	private int c_stavu;
	private Stav stav;
	private boolean zapnuto;
	private long zacatek;
	Timer tm = new Timer();

	public DrawingPanel() {
		this.setPreferredSize(new Dimension (800, 600));
		this.setBackground(Color.GRAY);
		c_stavu = 1;
		stav = new Stav(c_stavu);
		zapnuto = true;
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyChar() == 't') {	
					tm.cancel();
					stav.c_stavu++;
					if(stav.c_stavu>10) {
						stav.c_stavu = 1;
					}
					repaint();
				}
				/* vypnuti/zapnuti krizovatky */
				if(e.getKeyChar() == 'o') {
					
					tm.cancel();
					Timer prechodny = new Timer();
					zacatek = System.currentTimeMillis();
					prechodny.schedule( new TimerTask() {
						
						@Override
						public void run() {
							long time = System.currentTimeMillis() - zacatek;
							while(time < 1000) {
								stav.c_stavu = 11;
								repaint();
								time = System.currentTimeMillis() - zacatek;
							}
							this.cancel();
							
						}
					}, 0, 1000);
					
					if(zapnuto) {
						zapnuto = false;
						tm = new Timer();
						tm.schedule( new TimerTask() {
							
							@Override
							public void run() {
								if(stav.c_stavu == 12) {
									stav.c_stavu = 13;
									repaint();
								}else {
									stav.c_stavu = 12;
									repaint();
								}
								
								
							}
						}, 0, 1000);
						 
					}else {
						zapnuto = true;
					
						tm = new Timer();
						tm.schedule( new TimerTask() {
							
							@Override
							public void run() {
									stav.c_stavu = 1;
									repaint();
								}							
								
						}, 0, 1000);
					}
			}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		drawCrossRoad(g2);
	}

	private void drawCrossRoad(Graphics2D g2) {
		drawBackground(g2);
		TrafficLight[] carTL = new TrafficLight[11];
		TrafficLight2[] pedestTL = new TrafficLight2[6];
		setTrafficLights(g2, carTL, pedestTL);
		drawPrujezd(g2);
		stav.drawStav(carTL, pedestTL);
	}
	
	private void drawPrujezd(Graphics2D g2) {
		int stepY = this.getHeight()/30;
		int stepY2 = ((this.getHeight()/2 + stepY) - (this.getHeight()/3 + stepY) )/ 3;
		int stepX = this.getWidth()/30;
		int stepX2 = ((this.getWidth()/2 + stepX) - (this.getWidth()/3 + stepX) )/ 3;
		int round = 150;
		g2.setStroke(new BasicStroke(20, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
		switch (stav.c_stavu) {
		case 1:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawLine(-3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2, this.getWidth()+3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2);
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, 2 * this.getHeight()/3 - stepY - stepY2/2 , 2 * this.getWidth()/3 + 3 * stepX, 2 * this.getHeight()/3, round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(this.getWidth()/3 + stepX, 2 * this.getHeight()/3 + 9 * stepY/4, 2 * this.getWidth()/3 - stepX, 2 * this.getHeight()/3 + 9 * stepY/4);		
		break;
		case 2:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawLine(-3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2, this.getWidth()+3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2);
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, 2 * this.getHeight()/3 - stepY - stepY2/2 , 2 * this.getWidth()/3 + 3 * stepX, 2 * this.getHeight()/3, round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(this.getWidth()/3 + stepX, 2 * this.getHeight()/3 + 9 * stepY/4, 2 * this.getWidth()/3 - stepX, 2 * this.getHeight()/3 + 9 * stepY/4);	
		break;
		case 3:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawLine(-3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2, this.getWidth()+3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2);
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.drawRoundRect(-this.getWidth()/3,- this.getHeight()/3,  this.getWidth() - stepX - stepX2/2, this.getHeight() - stepY - 5* stepY2/2, round * 3, round * 3);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, 2 * this.getHeight()/3 - stepY - stepY2/2 , 2 * this.getWidth()/3 + 3 * stepX, 2 * this.getHeight()/3, round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(this.getWidth()/3 + stepX, 2 * this.getHeight()/3 + 9 * stepY/4, 2 * this.getWidth()/3 - stepX, 2 * this.getHeight()/3 + 9 * stepY/4);	
		break;
		case 4:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawLine(-3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2, this.getWidth()+3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, 2 * this.getHeight()/3 - stepY - stepY2/2 , 2 * this.getWidth()/3 + 3 * stepX, 2 * this.getHeight()/3, round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(this.getWidth()/3 + stepX, 2 * this.getHeight()/3 + 9 * stepY/4, 2 * this.getWidth()/3 - stepX, 2 * this.getHeight()/3 + 9 * stepY/4);	
		break;
		case 5:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawLine(-3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2, this.getWidth()+3, 2 * this.getHeight()/3 - stepY - 3 * stepY2/2);
			g2.drawLine(-3, this.getHeight()/3 + stepY +  3 * stepY2/2, this.getWidth()+3, this.getHeight()/3 + stepY + 3 * stepY2/2);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, 2 * this.getHeight()/3 - stepY - stepY2/2 , 2 * this.getWidth()/3 + 3 * stepX, 2 * this.getHeight()/3, round, round);
			g2.drawRoundRect(2 * this.getWidth()/3 - stepX, -this.getHeight()/3 , 2 * this.getWidth()/3, 2 * this.getHeight()/3 + 3 + stepY + stepY2/2, round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(this.getWidth()/3 + stepX, 2 * this.getHeight()/3 + 9 * stepY/4, 2 * this.getWidth()/3 - stepX, 2 * this.getHeight()/3 + 9 * stepY/4);	
			g2.drawLine(this.getWidth()/3 + stepX, this.getHeight()/3 - 9 * stepY/4,  2 * this.getWidth()/3 - stepX, this.getHeight()/3 - 9 * stepY/4);
		break;
		case 7:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.drawLine(this.getWidth()/3 + stepX + 3 * stepX2/2, -3, this.getWidth()/3 + stepX + 3 * stepX2/2, this.getHeight()+3);
			g2.drawLine(2 * this.getWidth()/3 - stepX - 3 * stepX2/2, -3, 2 * this.getWidth()/3 - stepX - 3 * stepX2/2, this.getHeight()+3);
			g2.setColor(new Color(1, .5f, 0, .5f));
			g2.drawRoundRect(2 * this.getWidth()/3 - stepX - stepX2/2, 2 * this.getHeight()/3 - stepY - stepY2, 2 * this.getWidth()/3, 2 * this.getHeight()/3, round, round);
			g2.drawRoundRect(-this.getWidth()/3, this.getHeight()/3 + stepX + stepX2, this.getWidth() - stepX - 5 * stepX2/2, this.getHeight(), round, round);
			g2.setColor(new Color(0, 1, 0, .5f));
			g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/15, this.getHeight()/3 + stepY, 2 * this.getWidth()/3 + this.getWidth()/15, 2 * this.getHeight()/3 - stepY);
		break;	
		case 8:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.drawLine(this.getWidth()/3 + stepX + 3 * stepX2/2, -3, this.getWidth()/3 + stepX + 3 * stepX2/2, this.getHeight()+3);
		break;
		case 9:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
			g2.drawLine(this.getWidth()/3 + stepX + 3 * stepX2/2, -3, this.getWidth()/3 + stepX + 3 * stepX2/2, this.getHeight()+3);
			g2.drawRoundRect(2 * this.getWidth()/3 - stepX, -this.getHeight()/3 , 2 * this.getWidth()/3, 2 * this.getHeight()/3 + 3 + stepY + stepY2/2, round, round);
			g2.drawRoundRect(this.getWidth()/3 + stepX + 5 * stepX2/2, - this.getHeight()/3, 2 * this.getWidth()/3, this.getHeight() -  stepY - stepY2, round, round);
		
		break;
		case 10:
			g2.setColor(new Color(1, 1, 0, .5f));
			g2.drawRoundRect(-this.getWidth()/3, -this.getHeight()/3,  2 * this.getWidth()/3 + stepX + stepX2/2, 2 * this.getHeight()/3 + stepY + stepY/2, round, round);
		break;	
		
		default:	
		}
		
		
		
	}

	private void drawBackground(Graphics2D g2) {
		this.h = this.getHeight();
		this.w = this.getWidth();
		int sirka;
		int vyska;
		int rohy = 50;
		
		sirka = w/3 + 50;
		vyska = h/3 + 50;
		
		double posun = (double)2/(double)3;

		g2.setColor(Color.GREEN);
		AffineTransform oldTr = g2.getTransform();
		
		g2.setColor(Color.DARK_GRAY);
		g2.fillRoundRect(-50, -50, sirka, vyska, rohy, rohy);
		g2.translate(0, posun * h + 50);
		g2.fillRoundRect(-50, -50, sirka, vyska, rohy, rohy);
		g2.translate(posun * w + 50, 0);
		g2.fillRoundRect(-50, -50, sirka, vyska, rohy, rohy);
		g2.translate(0, -(posun * h + 50));
		g2.fillRoundRect(-50, -50, sirka, vyska, rohy, rohy);

		g2.setTransform(oldTr);
		
		drawPrechod(g2);
		g2.translate(0, (-1.0/3) * (h) - 3*h/20);
		drawPrechod(g2);
		g2.setTransform(oldTr);		
		drawPrechod2(g2);
		
		drawPruhy(g2);
		
	}

	private void setTrafficLights(Graphics2D g2, TrafficLight[] carTL, TrafficLight2[] pedestTL) {
		int sirka = this.getWidth()/20;
		int vyska = this.getHeight()/40;
		
		int step = this.getHeight()/30;
		int step2 = ((this.getHeight()/2 + step) - (this.getHeight()/3 + step) )/ 3;
		
		Souradnice s = new Souradnice(2 * this.getWidth()/3 - sirka, this.getHeight()/3 + step + step2/2 - vyska/2, 2 * this.getWidth()/3 - 2 * sirka, this.getHeight()/3 + step + step2/2 + vyska/2);
		carTL[0] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "sever");
		s = new Souradnice(2 * this.getWidth()/3 - sirka, this.getHeight()/3 + step + 3 * step2/2 - vyska/2, 2 * this.getWidth()/3 - 2 * sirka, this.getHeight()/3 + step + 3 * step2/2 + vyska/2);
		carTL[1] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "sever");
		
		s = new Souradnice(this.getWidth()/3 - this.getWidth()/6 + 2 * sirka, 2 * this.getHeight()/3 - step - step2/2 - vyska/2, this.getWidth()/3 - this.getWidth()/6 + sirka, 2 * this.getHeight()/3 - step - step2/2 + vyska/2);
		carTL[2] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "jih");
		s = new Souradnice(this.getWidth()/3 - this.getWidth()/6 + 2 * sirka, 2 * this.getHeight()/3 - step - 3 * step2/2 - vyska/2, this.getWidth()/3 - this.getWidth()/6 + sirka, 2 * this.getHeight()/3 - step - 3 * step2/2 + vyska/2);
		carTL[3] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "jih");
		s = new Souradnice(this.getWidth()/3 - this.getWidth()/6 + 2 * sirka, 2 * this.getHeight()/3 - step - 5 * step2/2 - vyska/2, this.getWidth()/3 - this.getWidth()/6 + sirka, 2 * this.getHeight()/3 - step - 5 * step2/2 + vyska/2);
		carTL[4] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "jih");
		
		/* pro chodce */
		s = new Souradnice(2 * this.getWidth() / 3 + this.getWidth()/20 + sirka/4, this.getHeight() / 3 - 3 * vyska/2, 2 * this.getWidth() / 3 + this.getWidth()/20 + 3 * sirka/4, this.getHeight() / 3 - vyska/2);
		pedestTL[0] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "sever");
		s = new Souradnice(2 * this.getWidth() / 3 + this.getWidth()/20 + sirka/4, 2 * this.getHeight() / 3 + vyska/2, 2 * this.getWidth() / 3 + this.getWidth()/20 + 3 * sirka/4,  2 * this.getHeight() / 3 + 3 * vyska/2);
		pedestTL[1] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "sever");

		step = this.getWidth()/30;
		step2 = ((this.getWidth()/2 + step) - (this.getWidth()/3 + step) )/ 3;
		
		s = new Souradnice(this.getWidth()/3 + step + step2/2 - vyska/2, this.getHeight()/3 - sirka, this.getWidth()/3 + step + step2/2 + vyska/2, this.getHeight()/3);
		carTL[5] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "zapad");
		s = new Souradnice(this.getWidth()/3 + step + 3 * step2/2 - vyska/2, this.getHeight()/3 - sirka, this.getWidth()/3 + step + 3 * step2/2 + vyska/2, this.getHeight()/3);
		carTL[6] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "zapad");
		s = new Souradnice(this.getWidth()/3 + step + 5 * step2/2 - vyska/2, this.getHeight()/3 - sirka, this.getWidth()/3 + step + 5 * step2/2 + vyska/2, this.getHeight()/3);
		carTL[7] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "zapad");
		
		s = new Souradnice(2 * this.getWidth()/3 - step - step2/2 - vyska/2, 2 * this.getHeight()/ 3, 2 * this.getWidth()/3 - step - step2/2 + vyska/2, 2 * this.getHeight()/ 3 - sirka);
		carTL[8] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "vychod");
		s = new Souradnice(2 * this.getWidth()/3 - step - 3 * step2/2 - vyska/2, 2 * this.getHeight()/ 3, 2 * this.getWidth()/3 - step - 3 * step2/2 + vyska/2, 2 * this.getHeight()/ 3 - sirka);
		carTL[9] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "vychod");
		s = new Souradnice(2 * this.getWidth()/3 - step - 5 * step2/2 - vyska/2, 2 * this.getHeight()/ 3, 2 * this.getWidth()/3 - step - 5 * step2/2 + vyska/2, 2 * this.getHeight()/ 3 - sirka);
		carTL[10] = new TrafficLight(g2,s.x1, s.y1, s.x2, s.y2, "vychod");
		

		/* pro chodce */
		s = new Souradnice(this.getWidth()/3 - 2 * vyska, this.getHeight()/3 - this.getHeight()/20, this.getWidth()/3 - vyska, this.getHeight()/3 - this.getHeight()/20 - sirka/2);
		pedestTL[2] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "zapad");
		s = new Souradnice(2 * this.getWidth()/3 + vyska, this.getHeight()/3 - this.getHeight()/20, 2 * this.getWidth()/3 + 2 * vyska, this.getHeight()/3 - this.getHeight()/20 - sirka/2);
		pedestTL[3] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "zapad");
		
		s = new Souradnice(this.getWidth()/3 - 2 * vyska, 2 * this.getHeight()/3 + this.getHeight()/20 - sirka/4, this.getWidth()/3 - vyska,2 * this.getHeight()/3 + this.getHeight()/20 + sirka/4);
		pedestTL[4] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "vychod");
		s = new Souradnice(2 * this.getWidth()/3 + vyska, 2 * this.getHeight()/3 + this.getHeight()/20 - sirka/4, 2 * this.getWidth()/3 + 2 * vyska, 2 * this.getHeight()/3 + this.getHeight()/20 + sirka/4);
		pedestTL[5] = new TrafficLight2(g2, s.x1, s.y1, s.x2, s.y2, "vychod");	
	}

	private void drawPrechod(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		double stepX = this.getWidth()/40;
		double stepY = this.getHeight()/20;
		double startX = this.getWidth() / 3.0 + stepX;
		double startY = this.getHeight() * (2/3.0) + stepY;
		for(int i = 0; i < 12; i++) {
			g2.fill(new Rectangle2D.Double(startX + i *stepX, startY, stepX/2, stepY));
		}	
	}
	
	private void drawPrechod2(Graphics2D g2) {
		double stepX = this.getWidth()/20;
		double stepY = this.getHeight()/40;
		double startX = 2.0 * this.getWidth() / 3 + stepX;
		double startY = this.getHeight() / 3.0 + stepY;
		for(int i = 0; i < 12; i++) {
			g2.fill(new Rectangle2D.Double(startX, startY + i * stepY, stepX, stepY/2));
		}
	}
	
	private void drawPruhy(Graphics2D g2) {
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
		int step = this.getHeight()/30;
		/* JIH */
		int step2 = ((this.getHeight()/2 + step) - (this.getHeight()/3 + step) )/ 3;
		g2.drawLine(-3,2 * this.getHeight()/3 - step, this.getWidth()/3 - this.getWidth()/6, 2 * this.getHeight()/3 - step);
		g2.drawLine(-3,2 * this.getHeight()/3 - step - step2, this.getWidth()/3 - this.getWidth()/6, 2 * this.getHeight()/3 - step - step2);
		g2.drawLine(-3,2 * this.getHeight()/3 - step - 2 * step2, this.getWidth()/3 - this.getWidth()/6, 2 * this.getHeight()/3 - step - 2 * step2);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/6, 2 * this.getHeight()/3 - step, this.getWidth()/3 - this.getWidth()/6, this.getHeight()/2 - step);
		g2.drawLine(-3, this.getHeight()/2 - step, this.getWidth()/3 - this.getWidth()/6, this.getHeight()/2 - step);
		
		g2.drawLine(-3, 2 * this.getHeight()/3 - step - step2/2, this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - step2/2);
		g2.drawLine(-3, 2 * this.getHeight()/3 - step - 3 * step2/2, this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - 3 * step2/2);
		g2.drawLine(-3, 2 * this.getHeight()/3 - step - 5 * step2/2, this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - 5 * step2/2);
		
		/* sipky */
		int stranaY = this.getHeight()/100;
		int stranaX = this.getWidth()/100;
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 - 2 * stranaX, 2 * this.getHeight()/3 - step - step2/2 ,this.getWidth()/3 - this.getWidth()/4 - stranaX,  2 * this.getHeight()/3 - step - step2/2 + stranaY);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 - 2 * stranaX, 2 * this.getHeight()/3 - step - step2/2 + stranaY ,this.getWidth()/3 - this.getWidth()/4 - stranaX,  2 * this.getHeight()/3 - step - step2/2 + stranaY);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 - stranaX, 2 * this.getHeight()/3 - step - step2/2 ,this.getWidth()/3 - this.getWidth()/4 - stranaX,  2 * this.getHeight()/3 - step - step2/2 + stranaY);
		
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - step2/2, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - step2/2);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - step2/2  - stranaY, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - step2/2);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - step2/2  + stranaY, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - step2/2);
		
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - 3 * step2/2, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 3 * step2/2);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - 3 * step2/2 - stranaY, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 3 * step2/2);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4, 2 * this.getHeight()/3 - step - 3 * step2/2 + stranaY, this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 3 * step2/2);
		
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 5 * step2/2, this.getWidth()/3 - this.getWidth()/4 + stranaX,  2 * this.getHeight()/3 - step - 5 * step2/2 - stranaY);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 5 * step2/2 - stranaY, this.getWidth()/3 - this.getWidth()/4,  2 * this.getHeight()/3 - step - 5 * step2/2 - stranaY);
		g2.drawLine(this.getWidth()/3 - this.getWidth()/4 + stranaX, 2 * this.getHeight()/3 - step - 5 * step2/2 - stranaY, this.getWidth()/3 - this.getWidth()/4,  2 * this.getHeight()/3 - step - 5 * step2/2);
		
		
		/* SEVER */;
		step2 = (this.getHeight()/2 - (this.getHeight()/3 + step))/2 ;
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/6, this.getHeight()/3 + step, this.getWidth() + 3, this.getHeight()/3 + step);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/6, this.getHeight()/2, this.getWidth() + 3, this.getHeight()/2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/6, this.getHeight()/3 + step + step2, this.getWidth() + 3, this.getHeight()/3 + step + step2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/6, this.getHeight()/3 + step, 2 * this.getWidth()/3 + this.getWidth()/6, this.getHeight()/2);
		
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + step2/2, this.getWidth() + 3, this.getHeight()/3 + step + step2/2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + 3 * step2/2, this.getWidth() + 3, this.getHeight()/3 + step + 3 * step2/2);
		
		/* sipky */
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + step2/2, 2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + step2/2 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + step2/2, 2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + step2/2 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + step2/2 - stranaY, 2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + step2/2 - stranaY);
		
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + 3 * step2/2, 2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + 3 * step2/2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + 3 * step2/2, 2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + 3 * step2/2 + stranaY);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 - stranaX, this.getHeight()/3 + step + 3 * step2/2, 2 * this.getWidth()/3 + this.getWidth()/4, this.getHeight()/3 + step + 3 * step2/2 - stranaY);
		
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 + stranaX, this.getHeight()/3 + step + 3 * step2/2 + stranaY, 2 * this.getWidth()/3 + this.getWidth()/4 + 2 * stranaX, this.getHeight()/3 + step + 3 * step2/2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 + stranaX, this.getHeight()/3 + step + 3 * step2/2 + stranaY, 2 * this.getWidth()/3 + this.getWidth()/4 + stranaX, this.getHeight()/3 + step + 3 * step2/2);
		g2.drawLine(2 * this.getWidth()/3 + this.getWidth()/4 + stranaX, this.getHeight()/3 + step + 3 * step2/2 + stranaY, 2 * this.getWidth()/3 + this.getWidth()/4 + 2 * stranaX, this.getHeight()/3 + step + 3 * step2/2 + stranaY);
		
		/* ZAPAD */
		step = this.getWidth()/30;
		step2 = ((this.getWidth()/2 + step) - (this.getWidth()/3 + step) )/ 3;
		g2.drawLine(this.getWidth()/3 + step, -3, this.getWidth()/3 + step, this.getHeight()/3 - this.getHeight()/6);
		g2.drawLine(this.getWidth()/3 + step + step2, -3, this.getWidth()/3 + step + step2, this.getHeight()/3 - this.getHeight()/6);
		g2.drawLine(this.getWidth()/3 + step + 2 * step2, -3, this.getWidth()/3 + step + 2 * step2, this.getHeight()/3 - this.getHeight()/6);
		g2.drawLine(this.getWidth()/2 + step, -3, this.getWidth()/2 + step, this.getHeight()/3 - this.getHeight()/6);
		g2.drawLine(this.getWidth()/3 + step, this.getHeight()/3 - this.getHeight()/6, this.getWidth()/2 + step, this.getHeight()/3 - this.getHeight()/6);
		
		g2.drawLine(this.getWidth()/3 + step + step2/2, -3, this.getWidth()/3 + step + step2/2, (this.getHeight()/3 - this.getHeight()/6)/2);
		g2.drawLine(this.getWidth()/3 + step + 3 * step2/2, -3, this.getWidth()/3 + step + 3 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2);
		g2.drawLine(this.getWidth()/3 + step + 5 * step2/2, -3, this.getWidth()/3 + step + 5 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2);
		
		
		/* sipky */
		g2.drawLine(this.getWidth()/3 + step + step2/2, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + step2/2 - stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + step2/2 - stranaX, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + step2/2 - stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + step2/2 - stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY, this.getWidth()/3 + step + step2/2, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		
		g2.drawLine(this.getWidth()/3 + step + 3 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + 3 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + 3 * step2/2 - stranaX, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + 3 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + 3 * step2/2 + stranaX, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + 3 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		
		g2.drawLine(this.getWidth()/3 + step + 5 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + 5 * step2/2 + stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + 5 * step2/2 + stranaX, (this.getHeight()/3 - this.getHeight()/6)/2, this.getWidth()/3 + step + 5 * step2/2 + stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		g2.drawLine(this.getWidth()/3 + step + 5 * step2/2, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY, this.getWidth()/3 + step + 5 * step2/2 + stranaX, (this.getHeight()/3 - this.getHeight()/6)/2 + stranaY);
		
		/* VYCHOD */
		g2.drawLine(2 * this.getWidth()/3 - step, this.getHeight()+ 3, 2* this.getWidth()/3 - step, 2 * this.getHeight()/ 3 + this.getHeight()/6);
		g2.drawLine(2 * this.getWidth()/3 - step - step2, this.getHeight()+ 3, 2* this.getWidth()/3 - step - step2, 2 * this.getHeight()/ 3 + this.getHeight()/6);
		g2.drawLine(2 * this.getWidth()/3 - step - 2 * step2, this.getHeight()+ 3, 2* this.getWidth()/3 - step - 2 * step2, 2 * this.getHeight()/ 3 + this.getHeight()/6);
		g2.drawLine(this.getWidth()/2 - step, this.getHeight()+ 3,this.getWidth()/2 - step, 2 * this.getHeight()/ 3 + this.getHeight()/6);
		g2.drawLine(this.getWidth()/2 - step, 2 * this.getHeight()/ 3 + this.getHeight()/6, 2 * this.getWidth()/3 - step, 2 * this.getHeight()/ 3 + this.getHeight()/6);
		
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2, this.getHeight()+ 3, 2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4);
		g2.drawLine(2 * this.getWidth()/3 - step - 3 * step2/2, this.getHeight()+ 3, 2 * this.getWidth()/3 - step - 3 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4);
		g2.drawLine(2 * this.getWidth()/3 - step - 5 * step2/2, this.getHeight()+ 3, 2 * this.getWidth()/3 - step - 5 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4);
		
		/* sipky */
		g2.drawLine(2 * this.getWidth()/3 - step - 5 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - 5 * step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - 5 * step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - 5 * step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - 5 * step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY, 2 * this.getWidth()/3 - step - 5 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		
		g2.drawLine(2 * this.getWidth()/3 - step - 3 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - 3 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4- stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - 3 * step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - 3 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4- stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - 3 * step2/2 + stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - 3 * step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4- stranaY);
		
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2 - stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2 + stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4, 2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4 - stranaY);
		
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2, 2 * this.getHeight()/ 3 + this.getHeight()/4 + 2 * stranaY, 2 * this.getWidth()/3 - step - step2/2 + stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 + stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2 + stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 + 2 * stranaY, 2 * this.getWidth()/3 - step - step2/2 + stranaX, 2 * this.getHeight()/ 3 + this.getHeight()/4 + stranaY);
		g2.drawLine(2 * this.getWidth()/3 - step - step2/2,  2 * this.getHeight()/ 3 + this.getHeight()/4 + stranaY, 2 * this.getWidth()/3 - step - step2/2 + stranaX,  2 * this.getHeight()/ 3 + this.getHeight()/4 + stranaY);
	}

}
