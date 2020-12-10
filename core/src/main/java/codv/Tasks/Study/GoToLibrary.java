package codv.Tasks.Study;

import codv.Areas.Library;
import codv.Codv;
import codv.Tasks.Task;

public class GoToLibrary extends Task {

    public GoToLibrary(Codv codv) {
        super(codv);
        init(new Library(), 0);
    }
}
