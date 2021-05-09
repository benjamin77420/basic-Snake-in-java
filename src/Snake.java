import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake{

    private Consts.Direction direction;
    private List<BodyBlocks> bodyParts = new ArrayList<BodyBlocks>();

    //constructor
    public Snake(){
        this.direction = Consts.Direction.STAND_STILL;// will not be in motion
        this.bodyParts.add(new BodyBlocks(Consts.START_X, Consts.START_Y));//a block for the head
        this.bodyParts.add(new BodyBlocks(Consts.START_X - Consts.UNIT_SIZE, Consts.START_Y));//a block for the head
    }

    public void setDirection(Consts.Direction newDirection){
        this.direction = newDirection;
    }

    public Consts.Direction getDirection(){
        return this.direction;
    }

    public List<BodyBlocks> getBodyParts() { return this.bodyParts; }

    //End Region

    // Region movment fucntions

    public void moveLeft(){ this.bodyParts.get(0).setX(this.bodyParts.get(0).getX() - Consts.UNIT_SIZE); }

    public void moveRight(){ this.bodyParts.get(0).setX(this.bodyParts.get(0).getX() + Consts.UNIT_SIZE); }

    public void moveup(){
        this.bodyParts.get(0).setY(this.bodyParts.get(0).getY() - Consts.UNIT_SIZE);
    }

    public void moveDown(){
        this.bodyParts.get(0).setY(this.bodyParts.get(0).getY() + Consts.UNIT_SIZE);
    }

    //ENd Region

    //border control
    public void checkBorders(){
        for(BodyBlocks block : this.bodyParts){
            if(block.getX() < 0 ) block.setX(Consts.WINDOW_WIDTH);
            else if(block.getX() > Consts.WINDOW_WIDTH) block.setX(0);
            if(block.getY() < 0) block.setY(Consts.WINDOW_HIGHT);
            else if(block.getY() > Consts.WINDOW_HIGHT) block.setY(Consts.WINDOW_UPPER_PANEL);
        }
    }

    public boolean eatCandy(Candy currCandy){
        boolean yummy = false;

        Rectangle head = new Rectangle(this.bodyParts.get(0).getX(), this.bodyParts.get(0).getY(), Consts.UNIT_SIZE, Consts.UNIT_SIZE);
        Rectangle candyRec = new Rectangle(currCandy.getX(), currCandy.getY(), Consts.UNIT_SIZE, Consts.UNIT_SIZE);

        if(head.intersects(candyRec)) {
            addBodyPart();
            yummy = true;
        }

        return yummy;
    }

    public void addBodyPart(){
        //add a new body part to the snake
        this.bodyParts.add(this.bodyParts.size()-1,new BodyBlocks(this.bodyParts.get(this.bodyParts.size()-1).getX(), this.bodyParts.get(this.bodyParts.size()-1).getY()));
    }

    public void paintSnake(Graphics graphics){
        graphics.setColor(Color.green);
        int i=0;
        for(BodyBlocks block : this.bodyParts){
            graphics.fillRect(block.getX(), block.getY(), block.getUnitSize(), block.getUnitSize());
            System.out.println("this is block index " + i++ + " X: " + block.getX() + " Y: " + block.getY());
        }
    }
    public void recalibrate() {
        //matching all the X,Y of the elements to the element behind them to make the illusion if a snake moving
        for (int i = this.bodyParts.size() - 1; i >= 1; i--) {
            this.bodyParts.get(i).setX(this.bodyParts.get(i - 1).getX());
            this.bodyParts.get(i).setY(this.bodyParts.get(i - 1).getY());
        }
    }

    public boolean biteMySelf(){
        Rectangle head = new Rectangle(this.bodyParts.get(0).getX(), this.bodyParts.get(0).getY(), Consts.UNIT_SIZE, Consts.UNIT_SIZE);

        for(int i=2; i<this.bodyParts.size()-1; i++){
            Rectangle bodyBlock = new Rectangle(this.bodyParts.get(i).getX(), this.bodyParts.get(i).getY(), Consts.UNIT_SIZE, Consts.UNIT_SIZE);
            if(head.intersects(bodyBlock))
                return false;
        }
        return true;
    }
}
