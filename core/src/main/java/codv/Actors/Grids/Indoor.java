package codv.Actors.Grids;

import codv.Codv;
import codv.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * 代表室内
 */
public class Indoor extends Grid{

    public Indoor(Codv codv, Grid[][] grids, Point position) {
        super(codv, grids, position);
        color = Color.WHITE;
        type = 2;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        changeColor();
    }
}
