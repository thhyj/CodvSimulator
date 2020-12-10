package codv.Areas;

import codv.Point;

public class postOffice extends Area{
    public postOffice() {
        if (rand.nextInt(2) < 1)
            init(new Point(2, 67), new Point(5, 69));
        else init(new Point(2, 62), new Point(5, 64));
    }
}
