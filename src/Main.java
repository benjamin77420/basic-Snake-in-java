import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Main extends JFrame{
    //TODO: we need to make a snake with a following boday and to create a candy every time

    Snake snake = new Snake();
    BodyBlocks[] snakeBody = new BodyBlocks[Consts.GAME_UNITS];


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
                    Thread.sleep(Consts.Level.MEDIUM.getLevelValue());
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
        graphics.fillRect(snake.getX(), snake.getY(), Consts.SNAKE_WIDTH, Consts.SNAKE_HIGHT);



        if(snakeBody.size() == 0){
            BodyBlocks newBlock = new BodyBlocks((snake.getX() + Consts.SNAKE_WIDTH), snake.getY());
            snakeBody.add(newBlock);
        }

        if(snake.getNumOfBlocks() > snakeBody.size()){
            BodyBlocks newBlock = new BodyBlocks(snakeBody.get(snakeBody.size()-1).getX() + snake.getWidth(), snakeBody.get(snakeBody.size()-1).getY());
            snakeBody.add(newBlock);
        }

        //recalibrat
        for(int i = 0; i < snakeBody.size();i++){
            if(i == 0){
                snakeBody.get(i).setX(snake.getX() + Consts.SNAKE_WIDTH);
                snakeBody.get(i).setY(snake.getY());
            }
        }

        for(BodyBlocks block : snakeBody){
            graphics.fillRect(block.getX(), block.getY(), block.getWidth(), block.getHight());
        }

        //border control
        if(snake.getX() > Consts.WINDOW_WIDTH - Consts.CANDY_WIDTH - Consts.WINDOW_BORDER) snake.setX(0);
        else if(snake.getX() < 0 ) snake.setX(Consts.WINDOW_WIDTH - Consts.SNAKE_WIDTH);
        if(snake.getY() > Consts.WINDOW_HIGHT - Consts.CANDY_HIGHT - Consts.WINDOW_BORDER) snake.setY(0);
        else if(snake.getY() < 0 ) snake.setY(Consts.WINDOW_HIGHT - Consts.SNAKE_WIDTH);
        System.out.println(snake.getX() + " ," + snake.getY());
    }

    public static void main(String[] args) {
        Main snake = new Main();
    }

}
