package codv.Tasks.Eat;

import codv.Codv;

public class Lunch extends Eat{
    public Lunch(Codv codv) {
        super(codv);
        init( 1650+ rand.nextInt(300));
    }
}
