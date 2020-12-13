package codv.Actors;

import codv.Codv;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Clock extends Actor {
    Sprite clock, hourHand, minuteHand;
    Codv codv;
    BitmapFont font;
    public Clock(Codv codv, int x, int y) {
        this.codv = codv;
        font = codv.manager.get("word.fnt");
        setX(x);
        setY(y);
        setSize(200, 200);
        clock = new Sprite((Texture)codv.manager.get("clock.png"));
        clock.setSize(200, 200);
        clock.setPosition(getX(), getY());
        hourHand = new Sprite((Texture)codv.manager.get("hourHand.png"));
        hourHand.setSize(8, 60);
        hourHand.setPosition(getX() + getWidth() / 2 - 3, getY() + getHeight() / 2 - 4);
        hourHand.setOrigin(4, 4);
        minuteHand = new Sprite((Texture)codv.manager.get("hourHand.png"));
        minuteHand.setSize(6, 80);
        minuteHand.setPosition(getX() + getWidth() / 2 - 2.25f, getY() + getHeight() / 2 - 5);
        minuteHand.setOrigin(3, 5);
    //    hourHand.setOriginBasedPosition(getX() + getWidth() / 2 - 3, getY() + getHeight() / 2 + 4);
  //      hourHand.rotate(270);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //hourHand.rotate(2.4f * delta / codv.gameScreen.gameStage.getThreshold());
        //hourHand.rotate(0.2f * delta / codv.gameScreen.gameStage.getThreshold());
        hourHand.setRotation(360 - codv.gameScreen.gameStage.getTime() / 150.0f * 30);
        minuteHand.setRotation(360 - codv.gameScreen.gameStage.getTime() / 150.0f * 360);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        clock.draw(batch);
        hourHand.draw(batch);
        minuteHand.draw(batch);
        if(codv.gameScreen.gameStage.getTime() < 1800)
        font.draw(batch, "A M.", getX() + 80, getY() - 20 );
        else
        font.draw(batch, "P M.", getX() + 80, getY() - 20 );
    }
}
