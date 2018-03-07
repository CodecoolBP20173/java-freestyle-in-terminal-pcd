import java.util.concurrent.TimeUnit;

public class Renderer {
    private static DisplayObj[] displayObjArray;
    private static int offsetX;
    private static int offsetY;
    private static int screenWidth;
    private static int screenHeight; 
    private static Color bgColor;

    Renderer() {
        offsetX = 2;
        offsetY = 1;
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

    /*public static void renderScreen(){
        
         It prints the display object array by their coordinates
        
        
        
            DisplayObj frame;
            DisplayObj menu;
            DisplayObj poop;
            DisplayObj heart;
            DisplayObj creature;
        

        

        /*Frame
        DisplayObj frame = displayObjArray["frame"];
        t.moveTo(offsetX + frame.getPosX(), offsetY + frame.getPosX());
        printSprite(frame);

        //Lifebar
        DisplayObj lifebar = displayObjArray["life"];
        t.moveTo(offsetX + lifebar.getPosX(), offsetY + lifebar.getPosX());
        printSprite(lifebar);

        //Creature
        DisplayObj creature = displayObjArray["creature"];
        t.moveTo(offsetX + creature.getPosX(), offsetY + creaturer.getPosX());
        printSprite(creature);

        //Heart
        DisplayObj heart = displayObjArray["heart"];
        t.moveTo(offsetX + heart.getPosX(), offsetY + heart.getPosX());
        printSprite(heart);

        //Pooptchi
        DisplayObj poop = displayObjArray["poop"];
        t.moveTo(offsetX + poop.getPosX(), offsetY + poop.getPosX());
        printSprite(poop);

        //Menu
        DisplayObj menu = displayObjArray["menu"];
        
        //printSprite(menu);
    }*/

    public static void printSprite(){//DisplayObj object) {
        //String[][] sprite = object.getSprite();
        //String[] spriteFrame = sprite[sprite.currentFrame];
        Terminal t = new Terminal();
        String[][] spriteFrames = {{
            "    _--_     _--_ \n\r",  
            "   (    )~~~(    )   \n\r" , 
            "    \\           /    \n\r" ,  
            "     (  \' _ `  )     \n\r" ,  
            "      \\       /      \n\r" ,  
            "    .__(      )       \n\r" ,  
            "   / !  `---\' \\      \n\r" ,  
            "  /  \\         !     \n\r" ,  
            " !   /\\        )     \n\r" ,  
            " !   !_\\       ).    \n\r" ,  
            "  \\    \\       ! \\   \n\r" , 
            "   \\___/   )  /__/   \n\r" , 
            "     \\    /   !      \n\r" ,  
            "     /   !   /       \n\r" ,  
            "    !   /__ /___     \n\r" ,  
            "    (______)____)    \n\r"
        },
        {
            "   _--_     _--_     \n\r" ,  
            "  (    )~~~(    )    \n\r" ,   
            "   \\           /     \n\r" ,   
            "    (  \' _ `  )      \n\r" ,   
            "     \\       /       \n\r" ,   
            "      (      )        \n\r" ,    
            "   _--\'`---_         \n\r" ,    
            "  /         \\___     \n\r" ,   
            " /   /       !  \\    \n\r" ,    
            "(   <        !__/    \n\r" ,   
            " \\   \\      /\\       \n\r" ,  
            "  \\--/   \\ /  \\  ._  \n\r" ,    
            "    \\\\`.    )-   \\/  ) \n\r" ,    
            "     !   !  \\`.    /  \n\r" ,    
            "     /  /__   \\__/   \n\r" ,   
            "    (______)         \n\r"
        },
        {
            "   _--_     _--_       \n\r" ,  
            "  (    )~~~(    )      \n\r" , 
            "   \\           /       \n\r" ,  
            "    (  \' _ `  )        \n\r" ,  
            "     \\       /         \n\r" ,  
            "      (      )          \n\r" ,  
            "    .--`---\'\\          \n\r" , 
            "   /        _>\\        \n\r" , 
            "  /  /-___-\'   )       \n\r" , 
            "/\'  (        _/        \n\r" , 
            "\\___/`------\' )        \n\r" ,  
            "     \\      `<         \n\r" ,  
            "   ___>-_     \\   /-\\   \n\r" , 
            "  /      `-_   `-/  /   \n\r" , 
            " (  \\---__/ `-_    /   \n\r" ,  
            "  \\__)         `-_/    \n\r"
        },
        {
            "    _--_     _--_         \n\r" , 
             "   (    )~~~(    )        \n\r" , 
            "    \\           /         \n\r" , 
             "     (  \' _ `  )          \n\r" , 
            "      \\       /           \n\r" , 
            "    .__(      )  ___       \n\r" , 
            "   /   /`---\'`-\'   \\      \n\r" , 
            "  /   /          ._/   __ \n\r" , 
             "/\'   /.-----\\___/     /  )\n\r" , 
             "\\___//          `----\'   !\n\r" , 
             "     \\            ______/ \n\r" , 
             "      `--_____----\'       \n\r" , 
             "        \\    /            \n\r" , 
             "        !   !             \n\r" , 
              "        /  /__            \n\r" , 
            "       (______)           \n\r"
        }
    };

        int renderPosX = offsetX; // + object.getPosX();
        int renderPosY = offsetY;// + object.getPosY();

        try {
        t.moveTo(renderPosY, renderPosX);
        for(int i = 0; i < spriteFrames[0].length; i++) {
            System.out.print(spriteFrames[0][i]);
        }

        TimeUnit.MILLISECONDS.sleep(500);
        t.moveTo(renderPosY, renderPosX);
        for (int i = 0; i < spriteFrames[1].length; i++) {
            System.out.print(spriteFrames[1][i]);
        }

        TimeUnit.MILLISECONDS.sleep(500);
        t.moveTo(renderPosY, renderPosX);
        for (int i = 0; i < spriteFrames[2].length; i++) {
            System.out.print(spriteFrames[2][i]);
        }

        TimeUnit.MILLISECONDS.sleep(500);
        t.moveTo(renderPosY, renderPosX);
        for (int i = 0; i < spriteFrames[3].length; i++) {
            System.out.print(spriteFrames[3][i]);
        }
    } catch (Exception e) {

    }


    }

    public static void main(String[] args) {
        printSprite();
    }
}



