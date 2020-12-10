package codv;

import codv.Actors.*;
import codv.DFA.Dfa;
import codv.Tasks.Eat.Breakfast;
import codv.Tasks.TouchFish.AdvanceSleep;
import codv.Tools.getDorm;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.io.*;

public class GameStage extends Stage {
    public Codv codv;
    public Grid[][] grids;
    public Student[] students;
    private int time = 0, day = 1, week = 1;
    private float last = 0;
    private float threshold = 0.016f;
    private boolean action = false;

    public  GameStage (Codv codv) {
        super(new StretchViewport(1000, 1000));
        //getRoot().setX(100);
        this.codv = codv;
    }

    public int getTime() {
        return time;
    }
    public int getDay() {
        return day;
    }


    public void init() {
        grids = new Grid[100][100];
        try {
            FileInputStream fileInputStream = new FileInputStream("map.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
         //   DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            int tempNum;
            for(int j = 99; j >= 0; --j) {
                for(int i = 0; i < 100; ++i) {
                    do {
                        tempNum = (int) (inputStreamReader.read()) - 48;
                    } while(tempNum < 0);
                //    tempNum = dataInputStream.readInt();
                    switch (tempNum) {
                        case 0:
                            grids[i][j] = new Space(codv, grids, new Point(i * 10, j * 10));
                            break;
                        case 1:
                            grids[i][j] = new Wall(codv, grids, new Point(i * 10, j * 10));
                            break;
                        case 2:
                            grids[i][j] = new Indoor(codv, grids, new Point(i * 10, j * 10));
                            break;
                        case 3:
                            grids[i][j] = new GreenBelt(codv, grids, new Point(i * 10, j * 10));
                            break;

                    }
                    addActor(grids[i][j]);
                  //  grids[i][j] =
                }
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());
            e.printStackTrace();
        }



        students = new Student[1000];
        for(int i = 0; i < 1000; ++i) {
            students[i] = new Student(codv, new getDorm(i));
            addActor(students[i]);
        //    students[i].initTask();
        }
    }

    public float getThreshold() {
        return threshold;
    }

    public boolean getAction() {
        return action;
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        last += delta;
        if(time == 0) {
            for(int i = 0; i < 1000; ++i){
                students[i].initTask();
            }
        }
        if(last > threshold) {
            action = true;
            last = 0;
            ++time;
            if(time % 150 == 0) {
                System.out.println(time / 150);
            }
            if(time >= 3600) {
                time = 0;
                day += 1;
                if(day > 7) {
                    day = 1;
                    ++week;
                }
            }

        } else {
            action = false;
        }
    }
}
