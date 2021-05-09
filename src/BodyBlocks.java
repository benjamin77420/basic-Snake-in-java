import java.awt.*;

public class BodyBlocks extends Unit{
    public BodyBlocks(int x, int y) {
        super(x, y, Consts.UNIT_SIZE);
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.green);
        graphics.fillRect(this.getX(), this.getY(), this.getUnitSize(), this.getUnitSize());
    }
}
