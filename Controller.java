class Controller {
    private static int hunger = 0;
    private static int depression = 0;
    private static int tamagotchiHealth = 10;
    private static int tickPerFrame = 5;
    private static long lastUpdateTick;

    public int currentMenu = 1;

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
            // Renderer.displayObjMap["healthBar"].currentFrame = this.tamagotchiHealth;  
        }       
    }

//     public void selectMenu(int menuIndex) {
//         switch (menuIndex) {
//             case 1:
//                 Renderer.displayObjMap["menuEat"].currentFrame = 1;
//                 Renderer.displayObjMap["menuParty"].currentFrame = 0;
//                 Renderer.displayObjMap["menuClean"].currentFrame = 0;
//                 this.currentMenu = 1;
//                 break;
//             case 2:
//                 Renderer.displayObjMap["menuEat"].currentFrame = 0;
//                 Renderer.displayObjMap["menuParty"].currentFrame = 1;
//                 Renderer.displayObjMap["menuClean"].currentFrame = 0;
//                 this.currentMenu = 2;
//                 break;
//             case 3:
//                 Renderer.displayObjMap["menuEat"].currentFrame = 0;
//                 Renderer.displayObjMap["menuParty"].currentFrame = 0;
//                 Renderer.displayObjMap["menuClean"].currentFrame = 1;
//                 this.currentMenu = 3;
//                 break;
//         }
//     }

//     public void poop() {
//         DisplayObj tamagotchi = Renderer.displayObjMap["tamagotchi"];
//     }
 }