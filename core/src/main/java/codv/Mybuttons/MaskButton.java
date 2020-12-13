package codv.Mybuttons;

import codv.Codv;
import codv.Tools.Sentences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MaskButton extends MyButton{
  //  Sentences sentences;
    Sound select;
    public MaskButton(Codv codv, int x, int y, int width, int height) {
        super(codv, x, y, width, height);
        select = codv.manager.get("select.wav");
        addListener( new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                clickedStatus = !clickedStatus;
                codv.reverseMasked();
                select.play();
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //clickedStatus = !clickedStatus;
                super.touchUp(event, x, y, pointer, button);
            }

        });
 //       sentences = new Sentences(codv, "口罩", (int)(getX() + 16), (int)getY());
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
  //      font.setColor(Color.BLACK);
        font.draw(batch, "口罩", getX() + 28, getY() + 24);
    }
}
