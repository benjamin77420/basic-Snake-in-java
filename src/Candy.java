import java.awt.*;
import java.util.List;
import java.util.Random;

public class Candy extends Unit {

    public Candy(int x, int y){
        super(x,y, Consts.UNIT_SIZE);
    }

    public void newCoordinates(List<BodyBlocks> snakeBody){
        Random rand = new Random();
        int validYCoordinate;
        int validXCoordinate;
        // rerandom X and Y points on the game panel grid, the loop will do an other loop until the cordinates are valid
        do{
            validYCoordinate = rand.nextInt(((int)Consts.WINDOW_HIGHT/Consts.UNIT_SIZE) *Consts.UNIT_SIZE);
            validXCoordinate = rand.nextInt(((int)Consts.WINDOW_WIDTH/Consts.UNIT_SIZE) *Consts.UNIT_SIZE);

            if(validYCoordinate <= Consts.WINDOW_UPPER_PANEL)
                continue;

            for(BodyBlocks blocks : snakeBody)
                if (blocks.getX() == validXCoordinate && blocks.getY() == validYCoordinate)
                    continue;

        }while (false);

        this.setX(validXCoordinate);
        this.setY(validYCoordinate);
    }

    public void paintNewCandy(Graphics graphics){
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(this.getX(), this.getY(), this.getUnitSize(), this.getUnitSize());
    }
}
