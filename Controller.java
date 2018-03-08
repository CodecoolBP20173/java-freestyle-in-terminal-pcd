class Controller {
    public static boolean alive = true;
    private static int hunger = 0;
    private static int depression = 0;
    private static int tamagotchiHealth = 10;
    private static int tickPerFrame = 10;
    private static long lastUpdateTick;

    public static int currentMenu = 1;

    public static void update() {
        //System.out.println(Controller.alive);
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
            if (Controller.tamagotchiHealth == 0) {
                Controller.alive = false;
                DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi"); 
                zoziGotchiObj.currentFrame = 0;
                zoziGotchiObj.autoAnimated = false;
                zoziGotchiObj.setSprite((Sprite)Game.spriteMap.get("dead"));
                Renderer.displayObjMap.put("zoziGotchi", zoziGotchiObj);
            }

            DisplayObj statusBarObj = (DisplayObj)Renderer.displayObjMap.get("statusBar"); 
            statusBarObj.currentFrame = 10 - Controller.tamagotchiHealth;
            Renderer.displayObjMap.put("statusBar", statusBarObj);
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
        switch (Controller.currentMenu) {
            case 1:
                DisplayObj zoziGotchiObj = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi"); 
                zoziGotchiObj.currentFrame = 0;
                zoziGotchiObj.busy = true;
                zoziGotchiObj.setSprite((Sprite)Game.spriteMap.get("eat"));
                Renderer.displayObjMap.put("zoziGotchi", zoziGotchiObj);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    

    public static void poop() {
        
    }
}
