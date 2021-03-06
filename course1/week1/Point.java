package coursera.course1.week1;

public class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int distance(Point p) {
        int X = x - p.getX();
        int Y = y - p.getY();
        return (int)Math.sqrt(X*X + Y*Y);
    }
}
