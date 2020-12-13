package codv.Tools;

import codv.Codv;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Modifier extends Actor {
    private Sound select, notOk;
    private Codv codv;
    private Sprite now, arrow,arrowTouched;
    private boolean touched = false;
    private int type; // add or minus， add is true, minus is false
    private PointerSimulator<Integer> modifyTarget;
    public Modifier(Codv codv, int x, int y, int width, int height, int type, PointerSimulator<Integer> target) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        modifyTarget = target;
        this.type = type;
        select = codv.manager.get("select.wav");
        notOk = codv.manager.get("notOk.wav");
        arrow = new Sprite((Texture) codv.manager.get("arrow.png"));
        arrowTouched = new Sprite((Texture) codv.manager.get("arrowTouched.png"));
        addListener(new ClickListener() {
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            touched = true;
                            //  System.out.println("233");
                            if(modifyTarget.value + type > 0 && modifyTarget.value + type < 6){
                                modifyTarget.value += type;
                                if(type == -1)
                                    codv.gameScreen.gameStage.mulThreshold(2f);
                                else {
                                    codv.gameScreen.gameStage.mulThreshold(0.5f);
                                }
                                select.play();
                            } else notOk.play();

                            return super.touchDown(event, x, y, pointer, button);
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            touched = false;
                            super.touchUp(event, x, y, pointer, button);
                        }
                    }
        );
        now = arrow;
        now.setPosition(getX(),getY());
        now.setSize(getWidth(), getHeight());
        now.setOrigin(now.getWidth() / 2, now.getHeight()/2);
        if(type == 1) {
            now.setRotation(-90);
        } else now.setRotation(90);
        now.setSize(getWidth(), getHeight());
        now = arrowTouched;
        now.setPosition(getX(),getY());
        now.setSize(getWidth(), getHeight());
        now.setOrigin(now.getWidth() / 2, now.getHeight()/2);
        if(type == 1) {
            now.setRotation(-90);
        } else now.setRotation(90);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(touched) {
            now = arrowTouched;
        } else {
            now = arrow;
        }



    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        now.draw(batch);
    }
}
