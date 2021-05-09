import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybordActions implements KeyListener{

    private Game window;

    public KeybordActions(Game window){this.window = window;}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37:
                if(window.snake.getDirection().getValue() == 1)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.LEFT);

                break;
            case 38:
                if(window.snake.getDirection().getValue() == 4)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.UP);
                break;
            case 39:
                if(window.snake.getDirection().getValue() == 2)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.RIGHT);
                break;
            case 40:
                if(window.snake.getDirection().getValue() == 3)break;//preventing a change of 180 degrees in movment direction
                window.snake.setDirection(Consts.Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
