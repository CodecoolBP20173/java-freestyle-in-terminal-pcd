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

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;

public class Game {
    public static long tick = 0;
    public static int timePerFrame = 100;
    public static void main(String[] args) {
        Test.testSpriteDeclare();
       /* while (true) {
            try {
                Thread.sleep(timePerFrame);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            tick++;
            if (tick == 200) {
                break;
            } 
       }*/
    }
}
