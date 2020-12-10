package codv.Areas;

import codv.Point;

public class Canteen extends Area{
    public Canteen() {
        switch (rand.nextInt(4)) {
            case 0:
                init(new Point(27, 68), new Point(35, 78));
                break;
            case 1:
                init(new Point(27, 82), new Point(35, 92));
                break;
            case 2:
                init(new Point(38, 68), new Point(46, 78));
                break;
            case 3:
                init(new Point(38, 82), new Point(46, 92));
                break;
        }
    }
}
