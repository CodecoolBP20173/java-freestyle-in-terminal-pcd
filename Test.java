import java.util.HashMap;
import java.io.*;

class Test {
	public static Sprite[] testSpriteDeclare() {
		Sprite returnArray[] = new Sprite[2];
		HashMap testSpritePalette = new HashMap();
		testSpritePalette.put('─', (char)27 + "[47m");
		testSpritePalette.put('█', (char)27 + "[40m");
        testSpritePalette.put('░', (char)27 + "[43m");
        testSpritePalette.put('▒', (char)27 + "[44m");
        testSpritePalette.put('▄', (char)27 + "[41m");
		Sprite testSprite1 = null;
		Sprite testSprite2 = null;
		
		try {
			testSprite1 = new Sprite(testSpritePalette,"stand_still_happy_anim.txt", 6, 33);
			testSprite2 = new Sprite(testSpritePalette, "heart.txt", 1, 6);
		} catch (IOException e) {
			System.out.println(e);
		}
        // for (int i = 0; i < testSprite.frames.length; i++) {
        //     for (int j = 0; j < testSprite.frames[0].length; j++) {
        //         System.out.println(testSprite.frames[i][j]);
        //     }
        // }
	returnArray[0] = testSprite1;
	returnArray[1] = testSprite2;
	return returnArray;
	}
}