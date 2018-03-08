import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Renderer {
    public static DisplayObj[] displayObjArray;
    public static int offsetX;
    public static int offsetY;
    public static int screenWidth;
    public static int screenHeight; 
    public static Color bgColor;

    public static void setDisplayObjArray(DisplayObj displayObjArrayInput, int index) {
        /**
         * It sets to the given DisplayObj paramter by its index
         * DisplayObj: given DisplayObj instance
         * int: index
         */
        displayObjArray[index] = displayObjArrayInput;
    }

    public static void setDisplayObjArray(DisplayObj[] displayObjArrayInput) {
        /**
         * It sets the displayObj array to the given array
         * DisplayObj[]: DisplayObjs array
         */
        displayObjArray = displayObjArrayInput;
    }

    public static DisplayObj[] getDisplayObjArray() {
        /**
         * It returns the currect DisplayObj array
         */
        return displayObjArray;
    }

    public static DisplayObj getDisplayObjArray(int index) {
        /**
         * It returns a DisplayObj by its index in the array
         * int: index in the array
         */
        return displayObjArray[index];
    }

    public static void renderScreen(){
        
        for (int i=0; i < Renderer.displayObjArray.length; i++) {
            Renderer.printSprite(Renderer.displayObjArray[i]);
        }
    }

    public static void createBackground() {
        StringBuilder builder = new StringBuilder();
        Terminal t = new Terminal();
        for (int i = 0; i < Renderer.screenWidth; i++) {
            builder.append(" ");
        }
        builder.append("\n");
        for (int j = 0; j < Renderer.screenHeight; j++) {
            System.out.print(t.rgbColorBg(255, 255, 255));
            System.out.print(builder.toString());
        }
   
    }

    public static void printSprite(DisplayObj object) {
        Sprite sprite = object.getSprite();
        String[] frame = sprite.getFrame(object.currentFrame);
        Terminal t = new Terminal();
        int renderPosX = 1 + offsetY + object.getPosY();
        int renderPosY = offsetX + object.getPosX();
        //t.moveTo(renderPosY, renderPosX);
        for (int i = 0; i < frame.length; i++) {
            t.moveTo(renderPosY, renderPosX+i);
            System.out.println(frame[i]);
        }
    }
}
