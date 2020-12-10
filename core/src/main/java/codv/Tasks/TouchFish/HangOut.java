package codv.Tasks.TouchFish;

import codv.Areas.PlayGround;
import codv.Codv;
import codv.Tasks.Task;

import java.awt.*;

public class HangOut extends Task {

    public HangOut(Codv codv) {
        super(codv);
        init(new PlayGround(), 0);
    }
}
