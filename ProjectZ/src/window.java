import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.lang.Math;

public class window extends Applet implements MouseMotionListener, MouseWheelListener
{
	// Initialize variables 
	
	int width, height;
	int mx, my;  // the mouse coordinates
	Point[] points;
	int N = 300;
	
	Image backbuffer;
	
	
	int x_speed = 1;		// Speed in x 
	int radius = 20;		// Radius des Balles
	int appletsize_x = 300; // Größe des Applets in x 
	int appletsize_y = 300;	// Größe des Applets in y 

	// Image Buffer
	private Image background;
	private Image dbImage;
	private Image building;
	private Graphics dbg;

	public void init()
	{
		
		//setBackground (Color.blue);
		try {
			// load map
			dbImage = ImageIO.read(new File("C:\\Users\\acer\\Documents\\JavaProjects\\ProjectZ\\src\\usamap.png"));
			background = ImageIO.read(new File("C:\\Users\\acer\\Documents\\JavaProjects\\ProjectZ\\src\\usamap.png"));
			// load building 
//			building = ImageIO.read(new File("C:\\Users\\acer\\Documents\\JavaProjects\\ProjectZ\\src\\building.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setSize(1200, 600);
		width = getSize().width;
		height = getSize().height;
		mx = width/2;
		my = height/2;
		
		points = new Point[ N ];
	    for ( int i = 0; i < N; ++i ) {
	    	int x = (int)(( Math.random() - 0.5 ) * width / 1.5);
	        int y = (int)(( Math.random() - 0.5 ) * height / 1.5);
	        points[i] = new Point( x, y );
	    }
	      
	    building = getImage(getDocumentBase(), "building.jpg");
	    
//	    backbuffer = createImage( width, height );
	    dbg = dbImage.getGraphics();
	    
	    addMouseMotionListener( this );
	}
	
	public void mouseMoved( MouseEvent e ) {
	      mx = e.getX();
	      my = e.getY();
	      showStatus( "Mouse at (" + mx + "," + my + ")" );

//	      update background 
	      dbg.drawImage(background, 0, 0, this );
	      
	      
	      // draw the choosen building
	      
	      my = my - (int)(building.getHeight(null))/2;
	      mx = mx - (int)(building.getWidth(null))/2;
	      
	      dbg.drawImage(building, mx, my, this);

	      repaint();
	      e.consume();
	}
	
//	public void MouseWheelEvent(Component source,
//            int id,
//            long when,
//            int modifiers,
//            int x,
//            int y,
//            int clickCount,
//            boolean popupTrigger,
//            int scrollType,
//            int scrollAmount,
//            int wheelRotation)
//	{}
	
	
	public void mouseDragged( MouseEvent e ) { }

//	public void start ()
//	{
//		// Initialize new thread
//		Thread th = new Thread (this);
//		// start thread 
//		th.start ();
//	}

//	public void stop()
//	{
//
//	}
//
//	public void destroy()
//	{
//
//	}

//	public void run ()
//	{
//		// Thread Priority 
//		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//
//		// Solange true ist läuft der Thread weiter
//		while (true)
//		{
//			
////			x_pos ++ ;
//			
//			// when the moving x-axis reach the applet size
////			if (x_pos > appletsize_x - radius)
////			{
////				// change direction
////				x_speed = -1;
////			}
////			// Ball moving 
////			else if (x_pos < radius)
////			{
////				// Ändern der Richtung des Balles
////				x_speed = +1;
////			}
////
////			// Verändern der x- Koordinate
////			x_pos += x_speed;
//
//			// update the ball movement 
//			repaint();
//
//			try
//			{
//				// Stop thread 
//				Thread.sleep (20);
//			}
//			catch (InterruptedException ex)
//			{
//				// do nothing
//			}
//
//			// set thread priority to max
//			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//		}
//	}

	/** Update - Methode, Realisierung der Doppelpufferung zur Reduzierung des Bildschirmflackerns */
	public void update (Graphics g)
	{
		// Initialize double buffer with background image 
//		if (dbImage == null)
//		{
//			dbImage = createImage (this.getSize().width, this.getSize().height);
//			dbg = dbImage.getGraphics ();
//		}
//
//		// set background
//		//dbg.setColor (getBackground ());
//		//dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
//
//		// set foreground
//		dbg.setColor (getForeground());
//		paint (dbg);
//
//		// draw buffer images
		g.drawImage (dbImage, 0, 0, this);
	}

	public void paint (Graphics g)
	{
//		g.drawImage (dbImage, 0, 0, this);
//		g.setColor  (Color.red);

		update ( g );
	}
	
	public boolean mouseDown (Event e, int x, int y)
	{
//		x_speed = - (x_speed);
		return true;
	}


	public void mouseWheelMoved(MouseWheelEvent event) {
	
		int zoom = event.getWheelRotation();
		
		mx = event.getX();
		my = event.getY();
		
		showStatus( "Mouse rotated (" + zoom + ")");
		
		// zoom out
		if(zoom >= 0)
		{
			dbg.setColor(Color.black);
//			dbg.drawImage (background, SIZE/2-current_size/2, 
//			        SIZE/2-current_size/2, current_size, current_size, this);
		}
		// zoom in
		else if(zoom < 0)
		{
			int width = building.getWidth(this);
			int height = building.getHeight(this);
			dbg.drawImage(building, 
					width, height, width/2, height/2,
					width, height, width, height,
					this);
			
		}
		
		repaint();
		event.consume();
		
	}
}
