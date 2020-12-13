package codv.Areas;

import codv.Point;

public class ClassRoom extends Area{
    public ClassRoom() {
        switch (rand.nextInt(9)) {
            case 0:
                init(new Point(63, 47), new Point(78, 54));
                break;
            case 1:
                init(new Point(63, 31), new Point(78, 38));
                break;
            case 2:
                init(new Point(71, 39), new Point(78, 46));
                break;
            case 3:
                init(new Point(83, 48), new Point(96, 54));
                break;
            case 4:
                init(new Point(90, 41), new Point(96, 47));
                break;
            case 5:
                init(new Point(83, 24), new Point(85, 37));
                break;
            case 6:
                init(new Point(83, 35), new Point(96, 37));
                break;
            case 7:
                init(new Point(83, 24), new Point(96, 25));
                break;
            case 8:
                init(new Point(94, 24), new Point(96, 36));
                break;
        }
    }
}
