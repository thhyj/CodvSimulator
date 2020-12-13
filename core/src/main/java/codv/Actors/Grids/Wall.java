package codv.Actors.Grids;

import codv.Codv;
import codv.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * 代表墙壁
 */
public class Wall extends Grid{

    public Wall(Codv codv, Grid[][] grids, Point position) {
        super(codv, grids, position);
        type = 1;
        color = Color.BLACK;
        retentionRate = 0;
        diffusionRate = 0;
    }
}
