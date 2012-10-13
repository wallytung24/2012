import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

import javax.imageio.ImageIO;

// update the building movement with mouse over 
public class Grid extends Applet implements MouseMotionListener 
{

   int width, height;
   int mx, my;  // the mouse coordinates
   Point[] points;
   int N = 300;
   Image img;
   Image backbuffer;
   Graphics backg;

   public void init() {
	  setSize(1200, 800);
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

      img = getImage(getDocumentBase(), "building.jpg");
      try {
		backbuffer = ImageIO.read(new File("C:\\Users\\acer\\Documents\\JavaProjects\\ProjectZ\\src\\usamap.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//      backbuffer = getImage(getDocumentBase(), "usamap.png");
    		  //createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( Color.white );

      addMouseMotionListener( this );
   }

   public void mouseMoved( MouseEvent e ) {
      mx = e.getX();
      my = e.getY();
      showStatus( "Mouse at (" + mx + "," + my + ")" );

      backg.drawImage( img, 0, 0, this );
      for ( int j = 1; j < N; ++j ) {
         Point A = points[j-1];
         Point B = points[j];
         backg.drawLine( mx+A.x, my+A.y, mx+B.x, my+B.y );
      }

      repaint();
      e.consume();
   }
   public void mouseDragged( MouseEvent e ) { }

   public void update( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this );
   }

   public void paint( Graphics g ) {
      update( g );
   }
}