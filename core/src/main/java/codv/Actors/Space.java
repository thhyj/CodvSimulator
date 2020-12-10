package codv.Actors;

import codv.Codv;
import codv.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * 代表空地
 */
public class Space extends Grid{

    public Space(Codv codv, Grid[][] grids, Point position) {
        super(codv, grids, position);
        color = Color.WHITE;
        type = 0;
        retentionRate = 0.5;
        diffusionRate = 0.1;
    }
}
