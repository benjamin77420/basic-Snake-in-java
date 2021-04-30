import javax.swing.*;

public class Snake{

    private int numOfBlocks;
    private int width;
    private int hight;

    private int X;
    private int Y;

    private Consts.Direction direction;

    //constructor
    public Snake(){
        this.numOfBlocks = 1;// starting with one block
        this.width = Consts.SNAKE_WIDTH;// will be altered for every candy the snake eat
        this.hight = Consts.SNAKE_HIGHT;// will keep this value
        this.X = Consts.START_X;//center screen
        this.Y = Consts.START_Y;//center screen
        this.direction = Consts.Direction.STAND_STILL;// will not be in motion
    }


    // Region GETTERS && SETTERS

    public void setNumOfBlocks(int numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDirection(Consts.Direction newDirection){
        this.direction = newDirection;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getNumOfBlocks() {
        return this.numOfBlocks;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return Y;
    }

    public int getWidth() { return this.width;}

    public int getHight() {
        return this.hight;
    }

    public Consts.Direction getDirection(){
        return this.direction;
    }

    //End Region

    // Region movment fucntions

    public void moveLeft(){
        this.X -= Consts.CANDY_WIDTH;
    }

    public void moveRight(){
        this.X += Consts.CANDY_WIDTH;
    }

    public void moveup(){
        this.Y -= Consts.CANDY_WIDTH;
    }

    public void moveDown(){
        this.Y += Consts.CANDY_WIDTH;
    }

    //ENd Region

    public void growBigger(){
        this.numOfBlocks++;
    }


}
