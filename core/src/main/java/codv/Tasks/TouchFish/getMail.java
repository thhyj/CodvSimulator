package codv.Tasks.TouchFish;

import codv.Areas.postOffice;
import codv.Codv;
import codv.Tasks.Task;

public class getMail extends Task {
    public getMail(Codv codv) {
        super(codv);
        init(new postOffice(), 0);
    }
}
