package codv.Tasks.Eat;

import codv.Codv;
import codv.Tasks.Eat.Eat;

public class Breakfast extends Eat {
    public Breakfast(Codv codv) {
        super(codv);
        init(900 + rand.nextInt(150));
    }
}
