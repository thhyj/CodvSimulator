package codv.Actors;

import codv.Areas.Library;
import codv.Codv;
import codv.DFA.Dfa;
import codv.Tasks.DoNothing;
import codv.Tasks.Eat.Breakfast;
import codv.Tasks.Eat.Dinner;
import codv.Tasks.Eat.Lunch;
import codv.Tasks.Study.AfterNoonClass;
import codv.Tasks.Study.GoToLibrary;
import codv.Tasks.Study.MorningClass;
import codv.Tasks.Task;
import codv.Point;
import codv.Tasks.TouchFish.AdvanceSleep;
import codv.Tasks.TouchFish.HangOut;
import codv.Tasks.TouchFish.Sleep;
import codv.Tasks.TouchFish.getMail;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.*;

public class Student extends Actor {
    static private Random rand = new Random();
    public Codv codv;
    public Grid[][] grids;
    private Point position, dormPos;
    public static final int diameter = 8;
    public Sprite red, orange, green;
    public int status;
    private LinkedList<Task> taskList;
    private Task runningTask;
    private Iterator<Task> taskIter;
    private float last = 0;
    private int dfaId = 0;


    public Student(Codv codv, Point position){
        this.codv = codv;
        this.position = position;
        this.dormPos = position;
        red = new Sprite((Texture)codv.manager.get("redCircle.png"));
        orange = new Sprite((Texture)codv.manager.get("orangeCircle.png"));
        green = new Sprite((Texture)codv.manager.get("greenCircle.png"));
        red.setSize(diameter, diameter);
        green.setSize(diameter, diameter);
        orange.setSize(diameter, diameter);
        taskList = new LinkedList<Task>();
        status = 0;
    }
    //明天把学生的行为改成DFA
    private void workingDay() {
        dfaId = 0;
        do {
            switch (dfaId) {
                case -1:{
                    taskList.add(new Sleep(codv, dormPos));
                    dfaId = 0;
                    break;
                }
                case 0:{
                    taskList.add(new AdvanceSleep(codv,dormPos));
                    dfaId = 1;
                    break;
                }
                case 1:{
                    taskList.add(new Breakfast(codv));
                    dfaId = 2;
                    break;
                }
                case 2:{
                    taskList.add(new MorningClass(codv));
                    dfaId = 3;
                    break;
                }
                case 3:{
                    taskList.add(new Lunch(codv));
                    dfaId = 4;
                    break;
                }
                case 4:{
                    taskList.add(new AfterNoonClass(codv));
                    dfaId = 5;
                    break;
                }
                case 5:{
                    taskList.add(new Dinner(codv));
                    if(rand.nextInt(10) < 3) {
                        dfaId = 6;

                    } else {
                        dfaId = 7;
                    }
                    break;
                }
                case 6:{
                    taskList.add(new getMail(codv));
                    dfaId = 7;
                    break;
                }
                case 7: {
                    int choice = rand.nextInt(10);
                    //回宿舍摸鱼
                    if(choice < 3) {
                        taskList.add(new AdvanceSleep(codv,dormPos));
                        dfaId = 0;
                        break;
                    } else {
                        //图书馆学习
                        if(choice < 6) {
                            dfaId = 8;
                        } else {
                            //教室学习
                            if(choice < 9) {
                                dfaId = 9;
                            } else {
                                dfaId = 10;
                            }
                        }
                    }
                    break;
                }
                case 8:{
                    taskList.add(new GoToLibrary(codv));
                    dfaId = -1;
                    break;
                }
                case 9:{
                    taskList.add(new AfterNoonClass(codv));
                    dfaId = -1;
                    break;
                }
                case 10: {
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new AdvanceSleep(codv, dormPos));
                    dfaId = 0;
                    break;
                }
            }
        } while(dfaId != 0);
    /*    taskList.add(new Breakfast(codv));
        taskList.add(new MorningClass(codv));
        taskList.add(new Lunch(codv));
        taskList.add(new AfterNoonClass(codv));
        taskList.add(new Dinner(codv));
        int choice = rand.nextInt(10);
        //回宿舍摸鱼
        if(choice < 3) {
            taskList.add(new AdvanceSleep(codv, dormPos));
        } else {
            //图书馆学习
            if(choice < 6) {
                taskList.add(new GoToLibrary(codv));
            } else {
                //教室学习
                if(choice < 9) {
                    taskList.add(new AfterNoonClass(codv));
                //操场闲逛
                } else {
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new HangOut(codv));
                    taskList.add(new AdvanceSleep(codv, dormPos));
                }
            }
        }
        taskList.add(new Sleep(codv, dormPos));*/
    }

    private void weekend() {

    }

    public void initTask() {
        taskList.clear();
        if(codv.gameScreen.gameStage.getDay() <= 5) {
            workingDay();
        } else {
            weekend();
        }
        taskIter = taskList.iterator();
        runningTask = taskIter.next();
    }

    private void update() {
        int nowx, nowy;
        nowx = position.x / 10;
        nowy = position.y / 10;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        last+=delta;
     //   System.out.println("last = " + last);
        if(last > codv.gameScreen.gameStage.getThreshold()) {
            last = 0;
            if(runningTask == null) {
                return;
            }
            if(runningTask.isRunning()) {
                position = runningTask.act();
            } else {
                if(runningTask.isFinish()) {
                    if(taskIter.hasNext()) {
                        runningTask = taskIter.next();
                    } else {
                        runningTask = null;
                    }
                } else
                if(codv.gameScreen.gameStage.getTime() >= runningTask.getStartTime()) {
                    runningTask.startTask(position);
                } else {
              //      position = DoNothing.act(position);
                }
            }
            //setPosition(position.x * 10, position.y * 10);
        } else {
            setPosition(getX() + (position.x * 10 - getX()) * last / codv.gameScreen.gameStage.getThreshold(),
                    getY() + (position.y * 10 - getY()) * last / codv.gameScreen.gameStage.getThreshold());
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (status == 0) {
            green.setPosition(getX(), getY());
            green.draw(batch);
        } else if(status == 1) {
            orange.setPosition(getX(), getY());
            orange.draw(batch);
        } else if(status == 2) {
            red.setPosition(getX(), getY());
            red.draw(batch);
        }
    }
}
