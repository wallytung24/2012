import java.awt.Graphics;


// basic level 
public class Room {
	private int worldWidth = 15;
	private int worldHeight = 10;
	private int blockSize = 52;
	
	public static Block[][] block;
	
	public Room() {
		define();
		
	}
	
	public void define() {	
		block = new Block[worldHeight][worldWidth];
		
		
		
		for(int y = 0; y<block.length; y++) {
			for(int x = 0; x<block[y].length; x++) {
				//(Screen.myWidth/2) - ((worldWidth*blockSize)/2) + 
				block[y][x] = new Block(
						/* (Screen.myWidth/2) - ((worldWidth*blockSize)/2) + */ (x * blockSize), 
						y * blockSize, 
						blockSize, blockSize, 
						Value.groundGrass, Value.airAir);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int y = 0; y<block.length; y++) {
			for(int x = 0; x<block[y].length; x++) {
				block[y][x].draw(g);
			}
		}
		
		
	}
	
	public void physics() {
		
	}
	
	public int getYBlockSize() {
		return worldWidth;
	}
	
	public int getXBlockSize() {
		return worldHeight;
	}
	
	public void setGroundID(int y, int x, int ID) {
		block[y][x].setGroundID(ID);
	}
	
	public void setAirID(int y, int x, int ID) {
		block[y][x].setAirID(ID);
	}
}
