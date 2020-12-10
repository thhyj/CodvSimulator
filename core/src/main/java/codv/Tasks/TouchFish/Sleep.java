package codv.Tasks.TouchFish;

import codv.Areas.Area;
import codv.Areas.Dorm;
import codv.Codv;
import codv.Tasks.Task;
import codv.Point;

import java.util.Random;

public class Sleep extends Task {
    static private Random rand = new Random();
    public Sleep(Codv codv, Point dormPos){
        super(codv);
        init(new Dorm(dormPos), 3000 + rand.nextInt(450));
    }
}
