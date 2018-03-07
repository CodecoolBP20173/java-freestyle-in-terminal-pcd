public class DisplayObj {
    private int posX; 
    private int posY;
    private Sprite sprite; 
    private int currentFrame; 
    private int tickPerFrame;
    private int lastUpdateTick; 
    private Sprite defaultSprite; 
    private boolean busy;
    
    DisplayObj(int posX, int posY, int width, int height, Sprite sprite, int tickPerFrame){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.tickPerFrame = tickPerFrame;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setTickPerFrame(int tick) {

    } 

    public int getTickPerFrame () {
        return this.tickPerFrame;
    }

    public void update() {

    }

}