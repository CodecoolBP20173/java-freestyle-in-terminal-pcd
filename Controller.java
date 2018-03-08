class Controller {
    private static int hunger = 0;
    private static int depression = 0;
    private static int tamagotchiHealth = 10;
    private static int tickPerFrame = 5;
    private static long lastUpdateTick;

    public static int currentMenu = 1;

    public void update() {
        long deltaTick = Game.tick - this.lastUpdateTick;
        if (deltaTick == this.tickPerFrame) {
            this.hunger++;
            this.depression++;
            if (this.hunger == 5) {
                this.tamagotchiHealth -= 2;
            }
            if (this.depression == 5) {
                this.tamagotchiHealth -=2;
            }
            //Renderer.displayObjMap.get("healthBar").currentFrame = this.tamagotchiHealth;  
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
                menuEat.currentFrame = 0;
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

    public void poop() {
        DisplayObj tamagotchi = (DisplayObj)Renderer.displayObjMap.get("zoziGotchi");
    }
}
