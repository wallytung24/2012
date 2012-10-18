import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Save {
	public void loadSave(File loadPath) {
		try {
			Scanner sc = new Scanner(loadPath);
			
			while(sc.hasNext()) {
				for(int y = 0; y<Screen.getYBlocks(); y++) {
					for(int x = 0; x<Screen.getXBlocks(); x++) {
//						Screen.room.setGroundID(y, x, sc.nextInt());
					}
				}
				
				for(int y = 0; y<Screen.getXBlocks(); y++) {
					for(int x = 0; x<Screen.getYBlocks(); x++) {
//						Screen.room.setAirID(y, x, sc.nextInt());
					}
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
