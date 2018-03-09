import java.util.Random;

class Controller {
    public static boolean alive = true;
    private static boolean dirty = false;
    private static int hunger = 3;
    private static int depression = 3;
    private static int tamagotchiHealth = 10;
    private static int tickPerFrame = 100;
    private static long lastUpdateTick;
    private static long poopTimer; 

    public static int currentMenu = 1;

    public static void update() {
        if (poopTimer != 0 && Game.tick == poopTimer) {
            addPoop();
        }
        //System.out.println("update");
        long deltaTick = Game.tick - Controller.lastUpdateTick;
        if (deltaTick == Controller.tickPerFrame && Controller.alive) {
            //System.out.println("Hunger:" + Controller.hunger);
            //System.out.println("Depression:" + Controller.hunger);
            //System.out.println("HP:" + Controller.tamagotchiHealth);
            Controller.hunger = Math.min((Controller.hunger + 1), 5);
            Controller.depression = Math.min((Controller.depression + 1), 5);
            if (Controller.hunger == 5) {
                Controller.tamagotchiHealth = Math.max((Controller.tamagotchiHealth-1), 0);
            }
            if (Controller.depression == 5) {
                Controller.tamagotchiHealth = Math.max((Controller.tamagotchiHealth-1), 0);
            }
            if (Controller.dirty) {
                Controller.tamagotchiHealth = Math.max((Controller.tamagotchiHealth-1), 0);
            }
            if (Controller.tamagotchiHealth == 0) {
                Controller.alive = false;
                DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi"); 
                zoziGotchiObj.currentFrame = 0;
                zoziGotchiObj.autoAnimated = false;
                zoziGotchiObj.setSprite((Sprite)Game.spriteMap.get("dead"));
                Renderer.displayObjMap.put("zoziGotchi", zoziGotchiObj);
            }
            upDateStatusBar();
            Random rand = new Random();
            int randNum = rand.nextInt(3) + 1;
            if (!Controller.dirty && (randNum == 3 || Controller.hunger == 0)) {
                poop();
            }
            Controller.lastUpdateTick = Game.tick;
        }       
    }

    public static void selectMenu(int menuIndex) {
        DisplayObj menuEat = (DisplayObj)Renderer.displayObjMap.get("menuEat");
        DisplayObj menuParty = (DisplayObj)Renderer.displayObjMap.get("menuParty");
        DisplayObj menuClean = (DisplayObj)Renderer.displayObjMap.get("menuClean");

        switch (menuIndex) {
            case 1:
                menuEat.currentFrame = 1;
                menuParty.currentFrame = 0;
                menuClean.currentFrame = 0;
                Controller.currentMenu = 1;
                break;
            case 2:
                menuEat.currentFrame = 0;
                menuParty.currentFrame = 1;
                menuClean.currentFrame = 0;
                Controller.currentMenu = 2;
                break;
            case 3:
                menuEat.currentFrame = 0;
                menuParty.currentFrame = 0;
                menuClean.currentFrame = 1;
                Controller.currentMenu = 3;
                break;
        }
    }

    public static void cooseMenu() {
        DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi");
        if (zoziGotchiObj.busy || !Controller.alive) {
            return;
        }
        switch (Controller.currentMenu) {
            case 1:
                // Eat
                eat();
                break;
            case 2:
                // Party
                party();
                break;
            case 3:
                // Clean
                if (Controller.dirty) {
                    shower();
                }
                break;
        }
        upDateStatusBar();
    }

    private static void upDateStatusBar() {
        DisplayObj statusBarObj = (DisplayObj)Renderer.displayObjMap.get("statusBar"); 
        statusBarObj.currentFrame = 10 - Controller.tamagotchiHealth; 
    }

    private static void eat() {
        DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi");
        zoziGotchiObj.currentFrame = 0;
        zoziGotchiObj.busy = true;
        zoziGotchiObj.setSprite((Sprite)Game.spriteMap.get("eat"));
        Controller.hunger = Math.max(Controller.hunger-1, -5);
        if (Controller.hunger < 0) {
            Controller.tamagotchiHealth = Math.max((Controller.tamagotchiHealth-1), 0);
        } else {
            Controller.tamagotchiHealth = Math.min((Controller.tamagotchiHealth+1), 10);
        }
    }

    private static void party() {
        DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi");
        zoziGotchiObj.currentFrame = 0;
        zoziGotchiObj.busy = true;
        zoziGotchiObj.setSprite((Sprite)Game.spriteMap.get("dance"));
        Controller.depression = Math.max(Controller.depression-1, -5);
        if (Controller.depression < 0) {
            Controller.tamagotchiHealth = Math.max((Controller.tamagotchiHealth-1), 0);
        } else {
            Controller.tamagotchiHealth = Math.min((Controller.tamagotchiHealth+1), 10);
        }
    }

    private static void shower() {
        DisplayObj poopObj = (DisplayObj)Renderer.displayObjMap.get("poop"); 
        poopObj.setSprite((Sprite)Game.spriteMap.get("emptypoop"));
        poopObj.currentFrame = 0;
        Controller.dirty = false;
    }

    private static void poop() {
        DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi");
        zoziGotchiObj.currentFrame = 0;
        zoziGotchiObj.busy = true;
        Sprite poopingSpr = (Sprite)Game.spriteMap.get("pooping");
        zoziGotchiObj.setSprite(poopingSpr);
        Controller.poopTimer = Game.tick + (long)(poopingSpr.frames.length * zoziGotchiObj.getTickPerFrame());
    }

    private static void addPoop() {
        DisplayObj poopObj = (DisplayObj)Renderer.displayObjMap.get("poop"); 
        poopObj.setSprite((Sprite)Game.spriteMap.get("poop"));
        poopObj.currentFrame = 0;
        Controller.dirty = true;
    }
}
