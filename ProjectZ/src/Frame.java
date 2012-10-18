
import java.awt.*;

import javax.swing.JApplet;


public class Frame extends JApplet {
	// name of the window
//	public static String title = "Tower Defense of Wally";
	
	// set size of JFrame 
	public static Dimension size = new Dimension (775, 525); 
	
	public Frame () {	
//		setResizable(false);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		
	}
	
	public void init() {
		
//		setLayout(new GridLayout(1, 1, 0, 0));
		setSize(size);
		Screen screen = new Screen();
		
		add(screen);
		
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		Frame frame = new Frame();
		
	}

}
