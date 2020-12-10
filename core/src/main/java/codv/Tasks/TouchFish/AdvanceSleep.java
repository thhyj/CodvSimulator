package codv.Tasks.TouchFish;

import codv.Areas.Dorm;
import codv.Codv;
import codv.Point;
import codv.Tasks.Task;

import java.util.Random;

public class AdvanceSleep extends Task {
    static private Random rand = new Random();
    public AdvanceSleep(Codv codv, Point dormPos){
        super(codv);
        init(new Dorm(dormPos), 0);
    }
}
