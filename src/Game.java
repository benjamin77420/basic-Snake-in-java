import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    GameScene gameScene;
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        this.setVisible(true);
        this.setSize(Consts.WINDOW_WIDTH,Consts.WINDOW_HIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        KeybordActions keybordActions = new KeybordActions(this);

        gameScene = new GameScene();
        gameScene.setBounds(0, 0, Consts.WINDOW_WIDTH,Consts.WINDOW_HIGHT);
        this.add(gameScene);
        this.addKeyListener(keybordActions);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public GameScene getGameScene() {

        return this.gameScene;
    }
}
