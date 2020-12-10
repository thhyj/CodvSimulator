package codv.Tasks.Eat;

import codv.Areas.Area;
import codv.Areas.Canteen;
import codv.Codv;
import codv.Point;
import codv.Tasks.Task;

import java.util.Random;

public class Eat extends Task {
    static protected Random rand = new Random();

    public void init(int startTime) {
        init(new Canteen(), startTime);
    }

    public Eat (Codv codv) {
        super(codv);
    }
}
