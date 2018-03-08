import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Renderer {
    public static HashMap displayObjMap;
    public static int offsetX;
    public static int offsetY;
    public static int screenWidth;
    public static int screenHeight; 
    public static Color bgColor;

    public static Iterator getIteratorForDisplayObjMap() {
        Iterator it = displayObjMap.entrySet().iterator();
        return it;
    }

    public static void renderScreen(){
        Iterator it = displayObjMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry mapItem = (Map.Entry)it.next();
            Renderer.printSprite((DisplayObj)mapItem.getValue());
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

        for (int i = 0; i < frame.length; i++) {
            t.moveTo(renderPosY, renderPosX+i);
            System.out.println(frame[i]);
        }
    }
}
