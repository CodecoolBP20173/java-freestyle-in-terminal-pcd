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

            //Renderer.displayObjMap["healthBar"].currentFrame = this.tamagotchiHealth;  
        }       
    }

    /*public void selectMenu(int menuIndex) {
        switch (menuIndex) {
            case 1:
                Renderer.displayObjMap.get("menuEat").currentFrame = 1;
                Renderer.displayObjMap.get("menuParty").currentFrame = 0;
                Renderer.displayObjMap.get("menuClean").currentFrame = 0;
                Controller.currentMenu = 1;
                break;
            case 2:
                Renderer.displayObjMap.get("menuEat").currentFrame = 0;
                Renderer.displayObjMap.get("menuParty").currentFrame = 1;
                Renderer.displayObjMap.get("menuClean").currentFrame = 0;
                Controller.currentMenu = 2;
                break;
            case 3:
                Renderer.displayObjMap.get("menuEat").currentFrame = 0;
                Renderer.displayObjMap.get("menuParty").currentFrame = 0;
                Renderer.displayObjMap.get("menuClean").currentFrame = 1;
                Controller.currentMenu = 3;
                break;
        }
    }

    public void poop() {
        DisplayObj tamagotchi = Renderer.displayObjMap.get("tamagotchi");
    }*/
}
