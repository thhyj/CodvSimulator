package codv.Tasks.Study;

import codv.Codv;

public class MorningClass extends GoToClass{
    public MorningClass(Codv codv) {
        super(codv);
        init( 1050+ rand.nextInt(450));
    }
}
