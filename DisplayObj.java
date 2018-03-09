class DisplayObj {
    private int posX;
    private int posY;
    private Sprite sprite;
    private Sprite defaultSprite;
    public int currentFrame;
    private int tickPerFrame;
    private long lastUpdateTick;
    public boolean busy;
    public boolean autoAnimated;

    public DisplayObj(int posX, int posY, Sprite sprite, Sprite defaultSprite, int tickPerFrame, boolean autoAnimated){
        this.posX = posX;
        this.posY = posY;
        this.sprite = sprite;
        this.defaultSprite = defaultSprite;
        this.tickPerFrame = tickPerFrame;
        this.lastUpdateTick = 0;
        this.busy = false;
        this.currentFrame = 0;
        this.autoAnimated = autoAnimated;
    }
    public void update() {
        if (!this.autoAnimated) {
            return;
        }
        long deltaTick = Game.tick - this.lastUpdateTick;
        if (deltaTick == this.tickPerFrame) {
            this.lastUpdateTick = Game.tick;
            if (this.currentFrame == (this.sprite.frames.length-1)) {
                if (this.busy) {
                    this.sprite = this.defaultSprite;
                    this.busy = false;
                } else {
                    this.currentFrame = 0;
                }
            } else {
                this.currentFrame++;
            }
        }
    }
    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public Sprite getSprite() {
        return this.sprite;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public Sprite getDefaultSprite() {
        return this.defaultSprite;
    }
    public void setDefaultSprite(Sprite sprite) {
        this.defaultSprite = sprite;
    }
    public int getTickPerFrame() {
        return this.tickPerFrame;
    }
}