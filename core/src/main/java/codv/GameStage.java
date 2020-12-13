package codv;

import codv.Actors.*;
import codv.Actors.Grids.*;
import codv.Mybuttons.MaskButton;
import codv.Tools.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.io.*;
import java.util.Random;

public class GameStage extends Stage {
    static private Random rand = new Random();
    public Codv codv;
    public Grid[][] grids;
    public Student[] students;
    private int time = 0, day = 1, week = 1;
    private float last = 0;
    private float threshold = 0.016f;
    public boolean pause = false;
    private boolean action = false;
    private Monitor infectdNumberMonitor, attackedNumberMonitor, uninfectedNumberMonitor;
    private Monitor virusConcentrationMonitor, dayMonitor, studentNumberMonitor;


    public  GameStage (Codv codv) {
        super(new StretchViewport(1200, 1000));
       // super(new ScalingViewport(Scaling.fillY, 1000, 1000));
        //getRoot().setX(100);
        this.codv = codv;
    }

    public int getTime() {
        return time;
    }
    public int getDay() {
        return day;
    }

    private void setControllerGroup(String string ,int x, int y, int width, int height, PointerSimulator<Integer> target) {
        addActor(new Sentences(codv,string, x - string.length() * 20, y + 14));
        addActor(new Modifier(codv, (int)(x + (double)50 * width / 16),y,width, height, 1, target));
        addActor(new Modifier(codv, x,y,width, height, -1, target));
        addActor(new Monitor(codv,target, x + 22, y + 14));
    }
    private void menuInit() {
        int x = 1140;
        addActor(new Sentences(codv,"潜伏期人数", x - 5 * 26, 400 ));
        infectdNumberMonitor = new Monitor(codv, codv.infectedNumber, x, 400);
        addActor(new Sentences(codv,"发病期人数", x - 5 * 26, 350  ));
        attackedNumberMonitor = new Monitor(codv, codv.attackedNumber, x, 350);
        addActor(new Sentences(codv,"鼠标点击区域病毒浓度:", 1000, 470));
        virusConcentrationMonitor = new FloatMonitor(codv, codv.virusConcentrationNumber, 1030, 450);
        addActor(new Sentences(codv, "Day:", 1070, 650));
        dayMonitor = new Monitor(codv, codv.dayNumber, 1120, 650);
        addActor(new Sentences(codv, "在校总人数", x - 5 * 26, 300));
        studentNumberMonitor = new Monitor(codv, codv.studentNumber, x, 300);
        addActor(new Sentences(codv, "未感染人数", x - 5 * 26, 250));
        uninfectedNumberMonitor = new Monitor(codv, codv.uninfectedNumber, x, 250);
        setControllerGroup("速度等级:", x - 30, 150, 16, 16, codv.speedNumber);
        addActor(uninfectedNumberMonitor);
        addActor(studentNumberMonitor);
        addActor(dayMonitor);
        addActor(virusConcentrationMonitor);
        addActor(infectdNumberMonitor);
        addActor(attackedNumberMonitor);
        addActor(new Clock(codv, 1000, 700));
        addActor(new MaskButton(codv, 1050, 200, 100, 30));
    //    addActor(new Sentences(codv,"口罩", 1050, 220  ));

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
                    grids[i][j].setZIndex(0);
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
            students[i].setZIndex(10000);
        }
      //  System.out.println("qwq = " + students[0].getParent().getChildren().size);
        //students[rand.nextInt(1000)].getInfected();
        students[rand.nextInt(1)].getInfected();
        menuInit();
    }

    public float getThreshold() {
        return threshold;
    }

    public void mulThreshold(float mi) {
        threshold *= mi;
    }

    public boolean getAction() {
        return action;
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    //    if(pause) return;
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
                codv.dayNumber.value += 1;
            }
        } else {
            action = false;
        }
    }
}
