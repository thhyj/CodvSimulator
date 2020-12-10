package codv.Areas;

import codv.Point;

import java.util.Random;

public class Area {
    protected Point leftBottom, rightTop;
    private int width, height;
    static protected Random rand = new Random();

    public void init(Point leftBottom, Point rightTop) {
        this.leftBottom = leftBottom;
        this.rightTop = rightTop;
        width = rightTop.x - leftBottom.x;
        height = rightTop.y - leftBottom.y;
    }

    public Area() {

    }

    public Area(Point leftBottom, Point rightTop) {
        init(leftBottom, rightTop);
    }
    public Point getRandomPoint() {
        return new Point(leftBottom.x + rand.nextInt(width), leftBottom.y + rand.nextInt(height));
    }
}
