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

public class Game {
    public static long tick = 0;
    public static long timePerFrame = 100;
    public static void main(String[] args) {
        Game.initialize();
        while (true) {
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < Renderer.displayObjArray.length; i++) {
                Renderer.displayObjArray[i].update();
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
        Sprite[] testSprites = new Sprite[2];
        try {
            testSprites[0] = new Sprite("stand_still_happy_anim.txt", 6, 33);
            testSprites[1] = new Sprite("heart2.txt", 1, 5);
        } catch (IOException e) {
            System.out.println(e);
        }
        DisplayObj testObject1 = new DisplayObj(5, 6, testSprites[0], testSprites[0], 10);
        DisplayObj testObject2 = new DisplayObj(50, 5, testSprites[1], testSprites[1], 10);

        Renderer.displayObjArray = new DisplayObj[2];
        Renderer.displayObjArray[0] = testObject1;
        Renderer.displayObjArray[1] = testObject2;
        Renderer.offsetX = 20;
        Renderer.offsetY = 0;
    }
}
