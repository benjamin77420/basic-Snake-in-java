public abstract class Unit{
    private int x;
    private int y;

    private int unitSize;

    public Unit(int x, int y, int unitSize) {
        this.x = x;
        this.y = y;
        this.unitSize = unitSize;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }
}
