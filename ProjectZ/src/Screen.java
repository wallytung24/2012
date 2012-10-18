import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;

public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	
	public static Image[] tileset_ground = new Image[100];
	public static Image[] tileset_air = new Image[100];
	
	public static Image background;
	
	public static Save save;
	
	public static boolean isFirst = true;
	
	public static int myWidth, myHeight;
	
	public static Room room;
	
//	public static Point msc = new Point(0, 0);
	
	public Screen() {
		thread.start();
		
	}
	
	public static int getXBlocks() {
		return room.getXBlockSize();
	}
	
	public static int getYBlocks() {
		return room.getYBlockSize();
	}

	public void define() {
		save = new Save();
		room = new Room();
		
		// image need to be under both src and bin folder		
		background = new ImageIcon("../images/usamap.png").getImage();
		background = background.getScaledInstance(myWidth, myHeight, Image.SCALE_SMOOTH);
		
		Image temp = null;
		temp = new ImageIcon("../images/grass.png").getImage();
		temp = temp.getScaledInstance(26, 26, Image.SCALE_FAST);
		
		for(int i = 0; i<tileset_ground.length; i++) {
			tileset_ground[i] = new ImageIcon(temp).getImage();
			tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
		}
		for(int i = 0; i<tileset_air.length; i++) {
			tileset_air[i] = new ImageIcon("images/building.jpg").getImage();
			tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
		}
		
//		save.loadSave(new File("../save/Mission1.saves"));
	}
	
	public void paintComponent(Graphics g) {
		
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			
			isFirst = false;
			
		}
		g.clearRect(0, 0, getWidth(), getHeight());
	
		g.drawImage(background, 0, 0, this);
		
//		room.draw(g);			// Drawing the +room 
	}
	
	public static int fpsFrame = 0, fps = 100000000;
	
	public void run()
	{	
		while(true) {
			room.physics();
			// game loop
			// character move and actions
			
			if(!isFirst) {
				
			}
			repaint();
			
			try {
				Thread.sleep(1);
			}
			catch (Exception e) {}
		}
	}
	
//	public static void setPoint(int x, int y) {
//		msc.x = x;
//		msc.y = y;
//	}
	
}
