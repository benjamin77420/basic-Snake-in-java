import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JFrame{
    //TODO : need to add a function that will check if the snake has bit his own tail

    Random rand = new Random();

    boolean playing = true;
    Snake snake = new Snake();
    JLabel points = new JLabel();// points label
    JLabel gameOver = new JLabel("GAME OVER!!!");
    //creating a new candy on the beginning of the game
    Candy candy = new Candy(rand.nextInt((int)Consts.WINDOW_WIDTH/Consts.UNIT_SIZE) *Consts.UNIT_SIZE,
                            rand.nextInt((int)Consts.WINDOW_HIGHT/Consts.UNIT_SIZE) *Consts.UNIT_SIZE);

    public static void main(String[] args) {
        Game snake = new Game();
    }

    public Game(){
        this.init();
        new Thread(() -> {
            while(true){
                if(playing) {
                    switch (snake.getDirection().getValue()) {
                        case 1:
                            snake.moveRight();
                            break;
                        case 2:
                            snake.moveLeft();
                            break;
                        case 3:
                            snake.moveup();
                            break;
                        case 4:
                            snake.moveDown();
                            break;
                    }
                    points.setText("Points: " + (snake.getBodyParts().size() - 2));// -2 is to count the head and the tail of the snake that the snake is made with
                    snake.recalibrate();
                    eatCandy();
                    playing = snake.biteMySelf();
                    repaint();
                    try{
                        Thread.sleep(Consts.Level.HARD.getLevelValue());
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }else{
                    gameOver.setVisible(true);
                    gameOver.setBounds(Consts.START_X, Consts.START_Y, 100, 20);
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

        this.points.setBounds(0,0, 100, 20);
        this.points.setVisible(true);

        KeybordActions keyAction = new KeybordActions(this);

        this.add(gameOver);
        this.addKeyListener(keyAction);
        this.add(points);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.setColor(Color.green);
        int i=0;
        snake.paintSnake(graphics);
        candy.paintNewCandy(graphics);
        //call to checkBorders in case our snake will leave the game panel
        snake.checkBorders();
    }

    public void eatCandy(){
        boolean yummy = snake.eatCandy(candy);
        if(yummy){
            candy.newCoordinates(snake.getBodyParts());
        }
    }
}
