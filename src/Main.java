import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    Snake snake = new Snake();

    public Main(){
        this.init();
        new Thread(() -> {
            while(true){
                switch (snake.getDirection().getValue()){
                    case 1:
                        snake.moveRight();break;
                    case 2:
                        snake.moveLeft();break;
                    case 3:
                        snake.moveup();break;
                    case 4:
                        snake.moveDown();break;
                }
                repaint();
                try{
                    Thread.sleep(Consts.Level.EASY.getLevelValue());
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void init(){
        this.setVisible(true);
        this.setSize(Consts.WINDOW_WIDTH, Consts.WINDOW_HIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("BBD & DG snake");

        JLabel points = new JLabel("Points: " + (snake.getNumOfBlocks() - 1));
        points.setBounds(0, 0, 100, 25);
        points.setVisible(true);

        KeybordActions keyAction = new KeybordActions(this);

        this.addKeyListener(keyAction);
        this.add(points);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.setColor(Color.green);
        graphics.fillRect((snake.getX() % Consts.WINDOW_WIDTH) , (snake.getY() % Consts.WINDOW_HIGHT), Consts.SNAKE_WIDTH, Consts.SNAKE_HIGHT);
        System.out.println(snake.getNumOfBlocks());
    }

    public static void main(String[] args) {
        Main snake = new Main();
    }


}
