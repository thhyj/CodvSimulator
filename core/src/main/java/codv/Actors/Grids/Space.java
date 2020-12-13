package codv.Actors.Grids;

import codv.Codv;
import codv.Point;

/**
 * 代表空地
 */
public class Space extends Grid{

    public Space(Codv codv, Grid[][] grids, Point position) {
        super(codv, grids, position);
     //   color = Color.WHITE;
     //   color = new Color(128.0f, 0.0f, 128.0f, 1.0f);
        type = 0;

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        changeColor();
    }
}
