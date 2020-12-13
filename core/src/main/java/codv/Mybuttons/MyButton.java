package codv.Mybuttons;

import codv.Codv;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyButton extends Actor {
    BitmapFont font;
    Codv codv;
    Sprite red, black, white;
    boolean clickedStatus = false;
    MyButton(Codv codv, int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        this.codv = codv;
        font = codv.manager.get("word.fnt") ;
        red = new Sprite((Texture) codv.manager.get("red.png"));
        white = new Sprite((Texture) codv.manager.get("white.png"));
        black = new Sprite((Texture) codv.manager.get("black.png"));
        red.setSize(width, height);
        white.setSize(width, height);
        black.setSize(width, height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if(clickedStatus == false) {
            white.setX(getX());
            white.setY(getY());
            //  white.setSize(16,16);
            white.draw(batch);
        } else {
            red.setX(getX());
            red.setY(getY());
            red.draw(batch);

        }
        font.setColor(Color.BLACK);
        font.draw(batch, "Start", getX() + 16, getY() + getHeight());
        super.draw(batch, parentAlpha);
    }
}
