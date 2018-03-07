import java.io.*;
import java.util.HashMap;

class Sprite {
	private String[][] frames;
	private int frameWidth;
	private int frameHeight;
	private int numberOfFrames;

	public Sprite(HashMap palette, String filepath, int numberOfFrames, int frameWidth, int frameHeight) {
		this.numberOfFrames = numberOfFrames;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.frames = new String [numberOfFrames][frameHeight];

		FileReader inputStream = null;
		try {
            inputStream = new FileReader(filepath);
            		
			int charCode;
			String [] 
			StringBuilder stringBuilder = new StringBuilder();
            while ((charCode = inputStream.read()) != -1) {
				if (character == '\n') {
					
				} else {

				}
				char character = (char)charCode;  
                System.out.println((character == '\n') ? "newline" : character);
            }	
		} finally {
		    	if (inputStream != null) {
		        	inputStream.close();
		    	}
		}		
	};

	public int getFrameHeight() {
		return this.frameHeight;
	};

	public int getFrameWidth() {
		return this.frameWidth;
	};

	public int getNumberOfFrames() {
		return this.numberOfFrames;
	};

	public String[] getFrame(int index) {
		return this.frames[index];
	};

}

class Game {
	public static void main(String [] args) {
		HashMap testSpritePalette = new HashMap();
		testSpritePalette.put('#', (char)27 + "[34m");
		testSpritePalette.put('O', (char)27 + "[43m");
		Sprite testSprite = new Sprite(testSpritePalette,"sprite_sheet.txt", 4, 14, 3);
	}
}