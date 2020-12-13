package codv.Tools;

import codv.Codv;
import com.badlogic.gdx.graphics.g2d.Batch;

public class FloatMonitor extends Monitor{
    private PointerSimulator<Float>target;
    public FloatMonitor(Codv codv, PointerSimulator<Float> target, int x, int y) {
        super(codv, x, y);
        this.target = target;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
    //    super.draw(batch, parentAlpha);
        getFont().draw(batch, target.value+"", x,  y);
    }
}
