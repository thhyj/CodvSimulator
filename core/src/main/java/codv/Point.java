package codv;

public class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public Point(Point rhs) {
        this.x = rhs.x;
        this.y = rhs.y;
    }

    public boolean equal(Point rhs) {
        return x == rhs.x && y == rhs.y;
    }
    public Point add(Point rhs) {
        return new Point(x + rhs.x, y + rhs.y);
    }
    public Point minus(Point rhs) {
        return new Point(x - rhs.x, y - rhs.y);
    }
    public boolean islegal() {
        return (x >= 0 && x < 100 && y >= 0 && y < 100);
    }

    public int getdis(Point rhs){
        return Math.abs(this.x - rhs.x) + Math.abs(this.y - rhs.y);
    }
    public void print() {
        System.out.println("x = " + x + " y =" + y);
    }

}
