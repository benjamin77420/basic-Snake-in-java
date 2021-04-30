import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybordActions implements KeyListener{

    private Main window;

    public KeybordActions(Main window){this.window = window;}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("the key " + e.getKeyCode() + " was pressed!!");
        switch (e.getKeyCode()){
            case 37:
                if(window.snake.getDirection().getValue() == 1)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.LEFT);
                System.out.println("going left");
                break;
            case 38:
                if(window.snake.getDirection().getValue() == 4)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.UP);
                System.out.println("going up");
                break;
            case 39:
                if(window.snake.getDirection().getValue() == 2)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.RIGHT);
                System.out.println("going right");
                break;
            case 40:
                if(window.snake.getDirection().getValue() == 3)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.DOWN);
                System.out.println("going down");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
