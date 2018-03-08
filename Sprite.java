import java.io.*;
import java.util.HashMap;
import java.util.Arrays;

class Sprite {
	public String[][] frames;
	public static HashMap spritePalette;
	static {
		spritePalette = new HashMap();
		Terminal t = new Terminal();
		spritePalette.put('─', t.rgbColorBg(255, 255, 255));
		spritePalette.put('G', t.rgbColorBg(127, 127, 127));
		spritePalette.put('░', t.rgbColorBg(239, 228, 177));
		spritePalette.put('$', t.rgbColorBg(153, 217, 234));
		spritePalette.put('M', t.rgbColorBg(185, 122, 87));
		spritePalette.put('@', t.rgbColorBg(255, 174, 201));
		spritePalette.put('B', t.rgbColorBg(112, 146, 190));
		spritePalette.put('█', t.rgbColorBg(215, 76, 76));
		spritePalette.put('W', t.rgbColorBg(60, 172, 13));
		spritePalette.put('A', t.rgbColorBg(23, 27, 0));
	}

	public Sprite(String filepath, int numberOfFrames, int frameHeight) throws IOException {		
		this.frames = new String [numberOfFrames][frameHeight];
		FileReader inputStream = null;

		try {
            inputStream = new FileReader(filepath);
            		
			int charCode;
            int frameCounter = 0;
            int lineCounter = 0;
        
			StringBuilder stringBuilder = new StringBuilder();
            while ((charCode = inputStream.read()) != -1) {
				char character = (char)charCode;
				if (character == '\n') {
                    this.frames[frameCounter][lineCounter] = stringBuilder.toString();
                    lineCounter++;
                    stringBuilder.setLength(0);
                    if (lineCounter == frameHeight) {
						lineCounter=0;
                        frameCounter++;   
                    }
			    } else {
                    String charPrint = this.spritePalette.get(character) + " ";
                    stringBuilder.append(charPrint);
				}
            }	
		} finally {
		    	if (inputStream != null) {
		        	inputStream.close();
		    	}
		}
	};

	public String[] getFrame(int index) {
		return this.frames[index];
	};

}