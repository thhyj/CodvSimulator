package codv.Areas;

import codv.Point;

public class Dorm extends Area{

    public Dorm(Point point) {
        leftBottom = point;
    }

    @Override
    public Point getRandomPoint() {
        return leftBottom;
    }
}
