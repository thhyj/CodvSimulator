package codv;

import codv.Tools.PointerSimulator;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Codv extends Game {
    public GameScreen gameScreen;
    public AssetManager manager;
    public PointerSimulator<Integer> infectedNumber, uninfectedNumber;
    public PointerSimulator<Integer> attackedNumber;
    public PointerSimulator<Integer> studentNumber;
    public PointerSimulator<Integer> dayNumber;
    public PointerSimulator<Float> virusConcentrationNumber;
    public PointerSimulator<Integer> speedNumber;
    private boolean masked = false;
    public int getInfectedNumber() {
        return infectedNumber.value;
    }

    public void setInfectedNumber(int infectedNumber) {
        this.infectedNumber.value = infectedNumber;
    }

    public void addInfectedNumber() {
        infectedNumber.value++;
    }

    public void minusInfectedNumber() {
        infectedNumber.value--;
    }

    public int getAttackedNumber() {
        return attackedNumber.value;
    }

    public void setAttackedNumber(int attackedNumber) {
        this.attackedNumber.value = attackedNumber;
    }

    public void addAttackedNumber() {
        attackedNumber.value++;
    }

    public void minusAttackedNumber() {
        attackedNumber.value--;
    }

    public boolean getMasked() {
        return masked;
    }
    public void setMasked(boolean newStatus) {
        masked = newStatus;
    }

    public void reverseMasked() {
        masked = !masked;
    }

    public void loadResources() {
        manager = new AssetManager();
        manager.load("block.png", Texture.class);
        manager.load("greenCircle.png", Texture.class);
        manager.load("redCircle.png", Texture.class);
        manager.load("orangeCircle.png", Texture.class);
        manager.load("word.fnt", BitmapFont.class);
        manager.load("black.png", Texture.class);
        manager.load("white.png", Texture.class);
        manager.load("red.png", Texture.class);
        manager.load("clock.png", Texture.class);
        manager.load("hourHand.png", Texture.class);
        manager.load("arrow.png", Texture.class);
        manager.load("arrowTouched.png", Texture.class);
        manager.load("select.wav", Sound.class);
        manager.load("notOk.wav", Sound.class);

        manager.finishLoading();
    }

    public PointerSimulator<Integer> getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(PointerSimulator<Integer> studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void minusStudentNumber() {
        studentNumber.value--;
    }

    public void minusUninfectedNumber() {
        uninfectedNumber.value--;
    }

    @Override
    public void create() {
        infectedNumber = new PointerSimulator<Integer>(0);
        attackedNumber = new PointerSimulator<Integer>(0);
        studentNumber = new PointerSimulator<Integer>(1000);
        uninfectedNumber = new PointerSimulator<Integer>(1000);
        dayNumber = new PointerSimulator<Integer>(1);
        virusConcentrationNumber = new PointerSimulator<Float>(0f);
        speedNumber = new PointerSimulator<Integer>(4);
        loadResources();
        gameScreen = new GameScreen(this);
        gameScreen.init();
        setScreen(gameScreen);
        Gdx.input.setInputProcessor(gameScreen.gameStage);
    }

}