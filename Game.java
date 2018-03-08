import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

/*
Attribute:
    int public timePerFrame
    long public tick
Methods:
    main ( ) the main loop is running here:
    startTime = getCurrentTime ( )
    Tamagotchi.update ( )
    for each Renderer.displayObjArray.update ( )
    Renderer.renderScreen ( )
    endTime = getCurrentTime ( )
    deltaTime = endTime - startTime
    tick++
    if deltaTime < timePerFrame
    sleep (timePerFrame - deltaTime)
*/

import java.io.IOException;
import java.util.HashMap;
import java.lang.*;


public class Game {
    public static long tick = 0;
    public static long timePerFrame = 100;
    private static Character tryToRead() {
        try {
            if (System.in.available() > 0) {
                return (char)System.in.read();
            }
        }
        catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }
    private static void handleInput(Character input) {
        if (input == 'a') {
            // TODO Controller for menu
            System.out.print("LEFT");
        } else if (input == 'd') {
            // TODO Controller for menu
            System.out.print("RIGHT");
        } else if (input == 'q') {
            System.exit(0);
        }
    }
    private static void run() {
        long startTime = System.currentTimeMillis();

        Iterator it = Renderer.getIteratorForDisplayObjMap();

        while(it.hasNext()) {
            Map.Entry mapItem = (Map.Entry)it.next();
            DisplayObj displayItem = (DisplayObj)mapItem.getValue();
            displayItem.update();
        }

        Renderer.renderScreen();
        long endTime = System.currentTimeMillis();
        long deltaTime = endTime - startTime;
        if (deltaTime < timePerFrame) {
            try {
                Thread.sleep(timePerFrame - deltaTime);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        Game.tick++;
    }

    public static void main(String[] args) {
        Game.initialize();
        while (true) {

            Character input = Game.tryToRead();
            if (input != null){
                Game.handleInput(input);
            } else {
                Game.run();
            }
        }
    }
    
    public static void initialize () {
        Renderer.screenHeight = 50;
        Renderer.screenWidth = 100;
        Renderer.createBackground();
        HashMap spriteMap = new HashMap();
        try {
            Sprite testSprite = new Sprite("stand_still_happy_anim.txt", 6, 33);
            spriteMap.put("standStill", testSprite);
            spriteMap.put("menu1", new Sprite("menu1.txt", 2, 7));
            spriteMap.put("menu2", new Sprite("menu2.txt", 2, 7));
            spriteMap.put("menu3", new Sprite("menu3.txt", 2, 7));
            spriteMap.put("pooping", new Sprite("pooping_spritesheet.txt", 1, 33));
            spriteMap.put("heart", new Sprite("heart2.txt", 1, 5));
        } catch (IOException e) {
            System.out.println(e);
        }
        DisplayObj standStill = new DisplayObj(5, 6, (Sprite)spriteMap.get("standStill"), (Sprite)spriteMap.get("standStill"), 10);
        DisplayObj menu1 = new DisplayObj(50, 5, (Sprite)spriteMap.get("menu1"), (Sprite)spriteMap.get("menu1"), 10);
        DisplayObj menu2 = new DisplayObj(50, 5, (Sprite)spriteMap.get("menu2"), (Sprite)spriteMap.get("menu2"), 10);
        DisplayObj menu3 = new DisplayObj(50, 5, (Sprite)spriteMap.get("menu3"), (Sprite)spriteMap.get("menu3"), 10);
        DisplayObj heart = new DisplayObj(5, 6, (Sprite)spriteMap.get("heart"), (Sprite)spriteMap.get("heart"), 10);

        Renderer.displayObjMap = new HashMap();
        Renderer.displayObjMap.put("standStill", standStill);
        Renderer.displayObjMap.put("menu1", menu1);
        Renderer.displayObjMap.put("menu2", menu2);
        Renderer.displayObjMap.put("menu3", menu3);
        Renderer.displayObjMap.put("heart", heart);

        Renderer.offsetX = 20;
        Renderer.offsetY = 0;
    }
}
