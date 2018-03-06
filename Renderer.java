import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;

public class Renderer {
    public static DisplayObject[] displayObjArray;
    public static int offsetX;
    public static int offsetY;
    public static int screenWidth;
    public static int screenHeight; 
    public static Color bgColor;

    Renderer() {
        offsetX = 0;
        offsetY = 0;
    }

    public static void setDisplayObjArray() {

    }

    public static DisplayObject[] getDisplayObjArray() {
        return displayObjArray;
    }

    public static renderScreen(){
        /*Print each element in displayObjectArray at position offsetX + 
        displayObjectArray.posX, offsetY + displayObjectArray.posY*/
    }
}