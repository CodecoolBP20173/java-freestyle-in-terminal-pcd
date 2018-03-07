import java.util.concurrent.TimeUnit;

public class Renderer {
    private static DisplayObj[] displayObjArray;
    private static int offsetX;
    private static int offsetY;
    private static int screenWidth;
    private static int screenHeight; 
    private static Color bgColor;

    Renderer() {
        offsetX = 0;
        offsetY = 0;
        screenHeight = 53;
        screenWidth = 182;
        /*
            tput cols tells you the number of columns.
            tput lines tells you the number of rows.
        */
    }

    Renderer(DisplayObj frame, DisplayObj lifebar, DisplayObj creature, DisplayObj heart, DisplayObj poop, DisplayObj menu) {
        offsetX = 0;
        offsetY = 0;
        screenHeight = 53;
        screenWidth = 182;
        displayObjArray = new DisplayObj[]{ frame, lifebar, creature, heart, poop, menu };
    }

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
        /**
         * It prints the display object array by their coordinates
         */
        
        /*
            DisplayObj frame;
            DisplayObj menu;
            DisplayObj poop;
            DisplayObj heart;
            DisplayObj creature;
        */

        Terminal t = new Terminal();

        //Frame
        DisplayObj frame = displayObjArray[0];
        t.moveTo(offsetX + frame.getPosX(), offsetY + frame.getPosX());
        System.out.print(frame.getContent());

        //Lifebar
        DisplayObj lifebar = displayObjArray[0];
        t.moveTo(offsetX + lifebar.getPosX(), offsetY + lifebar.getPosX());
        System.out.print(lifebar.getContent());

        //Creature
        DisplayObj creature = displayObjArray[1];
        t.moveTo(offsetX + creature.getPosX(), offsetY + creaturer.getPosX());
        System.out.print(creature.getContent());

        //Heart
        DisplayObj heart = displayObjArray[2];
        t.moveTo(offsetX + heart.getPosX(), offsetY + heart.getPosX());
        System.out.print(heart.getContent());

        //Pooptch
        DisplayObj poop = displayObjArray[3];
        t.moveTo(offsetX + poop.getPosX(), offsetY + poop.getPosX());
        System.out.print(poop.getContent());

        //Menu
        DisplayObj menu = displayObjArray[4];
        t.moveTo(offsetX + menu.getPosX(), offsetY + menu.getPosX());
        System.out.print(menu.getContent());
    }

    private void printArrayItem(DisplayObj[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getContent());
        }
    }
}

