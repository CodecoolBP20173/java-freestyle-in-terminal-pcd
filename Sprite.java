import java.io.*;
import java.util.HashMap;
import java.util.Arrays;

class Sprite {
	public String[][] frames;

	public Sprite(HashMap palette, String filepath, int numberOfFrames, int frameHeight) throws IOException {
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
                    String charPrint = palette.get(character) + " ";
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

