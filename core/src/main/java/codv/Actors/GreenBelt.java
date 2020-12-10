package codv.Actors;

import codv.Codv;
import codv.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * 代表绿化
 */
public class GreenBelt extends Grid{

    public GreenBelt(Codv codv, Grid[][] grids, Point position) {
        super(codv, grids, position);
        color = Color.GREEN ;
        type = 3;
        retentionRate = 0.5;
        diffusionRate = 0.1;
    }
}
