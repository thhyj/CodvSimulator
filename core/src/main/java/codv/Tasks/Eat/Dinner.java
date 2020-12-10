package codv.Tasks.Eat;

import codv.Codv;

public class Dinner extends Eat{
    public Dinner(Codv codv) {
        super(codv);
        init( 2400+ rand.nextInt(300));
    }
}
