public class Consts {
    //window measurements
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HIGHT = 400;
    public static final int WINDOW_UPPER_PANEL = 20;

    //starting point will be in the center of the screen
    public static final int START_X = WINDOW_WIDTH/2;
    public static final int START_Y = WINDOW_HIGHT/2;


    //snake measurements && candy measurements
    public static final int UNIT_SIZE = 20;

    //max game units
    public static final int GAME_UNITS = (WINDOW_WIDTH * WINDOW_WIDTH)/ UNIT_SIZE;

    //an enum that will represent the direction of the movment numerically
    public enum Direction {
        STAND_STILL(0),
        RIGHT(1),
        LEFT(2),
        UP(3),
        DOWN(4);

        private int directionValue;

        Direction(int value){
            this.directionValue = value;
        }

        public int getValue(){
            return this.directionValue;
        }
    }

    //game difficulty, speed in millis for the repaint function call
    public enum Level{
        HARD(100),
        MEDIUM(200),
        EASY(300);

        private int levelValue;

        Level(int millis){
            this.levelValue = millis;
        }

        public int getLevelValue(){
            return this.levelValue;
        }
    }
}
