import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {
	public int groundID;
	public int airID;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		this.groundID = groundID;
		this.airID = airID;
	}
	
	public void draw(Graphics g) {
//		g.drawRect(x, y, width, height);
		g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);
		
//		if(groundID == Value.groundGrass) 
//			g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);
//		else //(airID != Value.airAir) {
//		{
//			g.drawImage(Screen.tileset_ground[airID], x, y, width, height, null);
//		}
	}
	
	public void setGroundID(int ID) {
		ID = groundID;
	}
	
	public void setAirID(int ID) {
		ID = airID;
	}
}
