package codv;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Codv extends Game {
    public GameScreen gameScreen;
    public AssetManager manager;

    public void loadResources() {
        manager = new AssetManager();
        manager.load("block.png", Texture.class);
        manager.load("greenCircle.png", Texture.class);
        manager.load("redCircle.png", Texture.class);
        manager.load("orangeCircle.png", Texture.class);
        manager.finishLoading();
    }

    @Override
    public void create() {
        loadResources();
        gameScreen = new GameScreen(this);
        gameScreen.init();
        setScreen(gameScreen);
        Gdx.input.setInputProcessor(gameScreen.gameStage);
    }

}