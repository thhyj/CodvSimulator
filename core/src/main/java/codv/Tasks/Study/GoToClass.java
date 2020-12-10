package codv.Tasks.Study;

import codv.Areas.Canteen;
import codv.Areas.ClassRoom;
import codv.Codv;
import codv.Tasks.Task;

import java.util.Random;

public class GoToClass extends Task {
    static protected Random rand = new Random();

    public void init(int startTime) {
        init(new ClassRoom(), startTime);
    }

    public GoToClass (Codv codv) {
        super(codv);
    }
}
