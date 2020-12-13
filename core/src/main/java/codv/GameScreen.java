package codv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen extends ScreenAdapter {
    public GameStage gameStage;
    public Codv codv;
    public SpriteBatch batch;
    public int FPS;
    private int nowFPS;
    private long lastFPS;

    private BitmapFont font;

    public GameScreen(Codv codv) {
        this.codv = codv;
    }
    public void init() {
        gameStage = new GameStage(codv);
        gameStage.init();
        font = new BitmapFont();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(gameStage);
        font.setColor(Color.BLACK);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(TimeUtils.nanoTime() - lastFPS >= 1000000000) {
            lastFPS = TimeUtils.nanoTime();
            FPS = nowFPS;
            nowFPS = 0;
        }
        ++nowFPS;
        batch.begin();
        gameStage.act();
        gameStage.draw();

        font.draw(batch, "FPS:"+FPS, 1050, 50);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.getViewport().update(width, height);
        gameStage.getCamera().update();
    }
}
