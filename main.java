import java.awt.Dimension;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
	 	JFrame okno = new JFrame();
	 	okno.setTitle("Klatovsk� - Sukova");
	 	okno.setSize(800, 600);
	 	
	 	DrawingPanel panel = new DrawingPanel();
		
	 	okno.add(panel);
	 	okno.pack();
	 	System.out.println("Pro p�epnut� stavu k�i�ovatky stiskn�te - 't'");
	 	System.out.println("Pro vypnut�/zapnut� k�i�ovatky stiskn�te - 'o'");
	 	
	 	okno.setMinimumSize(new Dimension(800, 600));
	 	okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	okno.setLocationRelativeTo(null);
	 	okno.setVisible(true);

	}

}
