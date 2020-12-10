package codv.Tasks.Study;

import codv.Codv;

public class AfterNoonClass extends GoToClass{
    public AfterNoonClass(Codv codv) {
        super(codv);
        init( 1950+ rand.nextInt(300));
    }
}
