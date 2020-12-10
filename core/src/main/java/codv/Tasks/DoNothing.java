package codv.Tasks;


import java.util.Random;
import codv.Point;
public class DoNothing{
    static private Random rand = new Random();
    static public Point act(Point nowPos) {
        switch (rand.nextInt(4)) {
            case 0:
                return nowPos.add(new Point(1, 0));
            case 1:
                return nowPos.add(new Point(-1, 0));
            case 2:
                return nowPos.add(new Point(0, 1));
            default:
                return nowPos.add(new Point(0, -1));
        }
    }
}
