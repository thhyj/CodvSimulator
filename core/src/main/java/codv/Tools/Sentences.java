package codv.Tools;

import codv.Codv;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sentences extends Actor {
    public Codv codv;
    public String sentence;
    public int x, y;
    public BitmapFont font;

    /**
     *
     * @param codv 游戏主体类
     * @param sentence 要显示的字符串
     * @param x
     * @param y
     */
    public Sentences(Codv codv, String sentence, int x, int y) {
        this.sentence = sentence;
        this.x = x;
        this.y = y;
        this.codv = codv;
        this.font = codv.manager.get("word.fnt");
       // this.font.setColor(Color.BLACK);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, sentence, x, y);
    }
}
