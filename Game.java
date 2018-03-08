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
    public static HashMap spriteMap = new HashMap();
    public static HashMap objectMap = new HashMap();
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
        Terminal t = new Terminal();
        if (input == 'a') {
            if (Controller.currentMenu != 1){
                Controller.selectMenu(Controller.currentMenu-1);
                t.moveTo(80, 40);
                System.out.print(t.rgbColor(255, 0, 0));
                System.out.println(Controller.currentMenu);
            }
            
        } else if (input == 'd') {
            if (Controller.currentMenu != 3){
                Controller.selectMenu(Controller.currentMenu+1);
                t.moveTo(80, 40);
                System.out.print(t.rgbColor(255, 0, 0));
                System.out.println(Controller.currentMenu);
            }
            
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
        
        try {
            Sprite testSprite = new Sprite("stand_still_happy_anim.txt", 6, 33);
            spriteMap.put("standStill", testSprite);
            spriteMap.put("menuEat", new Sprite("menu1.txt", 2, 7));
            spriteMap.put("menuParty", new Sprite("menu2.txt", 2, 7));
            spriteMap.put("menuClean", new Sprite("menu3.txt", 2, 7));
            spriteMap.put("pooping", new Sprite("pooping_spritesheet.txt", 1, 33));
            spriteMap.put("heart", new Sprite("heart2.txt", 1, 5));
            spriteMap.put("statusBar", new Sprite("statusbar.txt", 11, 3));
            spriteMap.put("poop", new Sprite("poop.txt", 3, 19));
            spriteMap.put("eat", new Sprite("eat.txt", 6, 33));
        } catch (IOException e) {
            System.out.println(e);
        }
        DisplayObj zoziGotchi = new DisplayObj(15, 6, (Sprite)spriteMap.get("standStill"), (Sprite)spriteMap.get("standStill"), 10, true);
        DisplayObj menuEat = new DisplayObj(10, 40, (Sprite)spriteMap.get("menuEat"), (Sprite)spriteMap.get("menuEat"), 10, false);
        DisplayObj menuParty = new DisplayObj(25, 40, (Sprite)spriteMap.get("menuParty"), (Sprite)spriteMap.get("menuParty"), 10, false);
        DisplayObj menuClean = new DisplayObj(40, 40, (Sprite)spriteMap.get("menuClean"), (Sprite)spriteMap.get("menuClean"), 10, false);
        DisplayObj heart = new DisplayObj(5, 6, (Sprite)spriteMap.get("heart"), (Sprite)spriteMap.get("heart"), 10, true);
        DisplayObj statusBar = new DisplayObj(5, 6, (Sprite)spriteMap.get("statusBar"), (Sprite)spriteMap.get("statusBar"), 10, true);
        DisplayObj poop = new DisplayObj(5, 6, (Sprite)spriteMap.get("poop"), (Sprite)spriteMap.get("poop"), 10, true);

        Renderer.displayObjMap = new HashMap();
        Renderer.displayObjMap.put("zoziGotchi", zoziGotchi);
        Renderer.displayObjMap.put("menuEat", menuEat);
        Renderer.displayObjMap.put("menuParty", menuParty);
        Renderer.displayObjMap.put("menuClean", menuClean);
        Renderer.displayObjMap.put("heart", heart);
        Renderer.displayObjMap.put("statusbar", statusBar);


        Renderer.offsetX = 20;
        Renderer.offsetY = 0;
    }
}
