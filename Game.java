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
        Sprite testSprite = Test.testSpriteDeclare();
        DisplayObj testObject = new DisplayObj(5, 6, testSprite, testSprite, 10);

        Renderer.displayObjArray = new DisplayObj[1];
        Renderer.displayObjArray[0] = testObject;
        Renderer.offsetX = 20;
        Renderer.offsetY = 0;
    }
    public static HashMap loadSprites () {
        HashMap sprites = new HashMap;
        Sprite testSprite = null;
		try {
			testSprite = new Sprite(testSpritePalette,"stand_still_happy_anim.txt", 6, 33);
            sprites.put(name, testSprite);
		} catch (IOException e) {
			System.out.println(e);
		}
    }
}
