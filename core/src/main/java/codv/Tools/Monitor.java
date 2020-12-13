package codv.Tools;

import codv.Codv;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * 监视者类
 * 用于显示某个变量的值
 */
public class Monitor extends Actor {
    private Codv codv;
    private PointerSimulator<Integer> target;
    private BitmapFont font;
    public int x, y;

    /**
     *
     * @param codv 游戏主体类(树根)
     * @param target 监视的变量
     * @param x
     * @param y
     */
    public Monitor(Codv codv, PointerSimulator<Integer> target, int x, int y) {
        this.codv = codv;
        this.target = target;
        this.x = x;
        this.y = y;
        font = codv.manager.get("word.fnt");
     //   font.setColor(Color.BLACK);
    }

    public Monitor(Codv codv, int x, int y) {
        this.codv = codv;
        this.x = x;
        this.y = y;
        font = codv.manager.get("word.fnt");
    }

    public BitmapFont getFont() {
        return font;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(target.value < 10)
            font.draw(batch,target.value+"", x + 5, y);
        else if(target.value < 100)
            font.draw(batch,target.value+"", x + 1, y);
        else if(target.value < 1000) {
            font.draw(batch, target.value+"", x - 3, y);
        } else {
            font.draw(batch, target.value+"", x - 7, y);
        }
    }
}