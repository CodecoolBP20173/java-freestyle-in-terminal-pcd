import java.util.HashMap;
import java.io.*;

class Test {
	public static void testSpriteDeclare() {
		HashMap testSpritePalette = new HashMap();
		testSpritePalette.put('─', (char)27 + "[47m");
		testSpritePalette.put('█', (char)27 + "[40m");
        testSpritePalette.put('░', (char)27 + "[43m");
        testSpritePalette.put('▒', (char)27 + "[44m");
        testSpritePalette.put('▄', (char)27 + "[41m");
        Sprite testSprite = null;
		try {
			testSprite = new Sprite(testSpritePalette,"stand_still_happy_anim.txt", 6, 33);
		} catch (IOException e) {
			System.out.println(e);
		}
        for (int i = 0; i < testSprite.frames.length; i++) {
            for (int j = 0; j < testSprite.frames[0].length; j++) {
                System.out.println(testSprite.frames[i][j]);
            }
        }
	}
}