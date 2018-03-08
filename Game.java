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

public class Game {
    public static long tick = 0;
    public static long timePerFrame = 100;
    public static void main(String[] args) {
        Game.initialize();
        while (true) {
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
    }
    public static void initialize () {
        Renderer.screenHeight = 50;
        Renderer.screenWidth = 100;
        Renderer.createBackground();
        Sprite[] testSprites = Test.testSpriteDeclare();
        DisplayObj testObject1 = new DisplayObj(5, 6, testSprites[0], testSprites[0], 10);
        DisplayObj testObject2 = new DisplayObj(50, 5, testSprites[1], testSprites[1], 10);

        //Renderer.displayObjArray = new DisplayObj[2];
        //Renderer.displayObjArray[0] = testObject1;
        //Renderer.displayObjArray[1] = testObject2;

        Renderer.displayObjMap = new HashMap();
        Renderer.displayObjMap.put("creature", testObject1);
        Renderer.displayObjMap.put("heart", testObject2);
        Renderer.offsetX = 20;
        Renderer.offsetY = 0;
    }
}
