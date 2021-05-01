public class BodyBlocks {

    private int X;
    private int Y;

    private int width = Consts.SNAKE_WIDTH;
    private int hight = Consts.SNAKE_HIGHT;

    public BodyBlocks(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return this.X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return this.Y;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHight() {
        return this.hight;
    }
}
