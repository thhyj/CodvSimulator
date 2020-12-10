package codv.Tasks;

import codv.Areas.Area;
import codv.Codv;
import codv.Navagate.Path;
import codv.Point;

public class Task {
    private Codv codv;
    private Point endPoint, startPoint;
    private Area startArea, endArea;
    private int startTime;
    private Path path;
    private boolean running = false, finish = false;
    public void init(Area endArea, int startTime) {
        this.endArea = endArea;
        this.startTime = startTime;
    }

    public Task(Codv codv) {
        this.codv = codv;
    }

    public Task (Codv codv, Area endArea, int startTime) {
        this.codv = codv;
        this.startArea = startArea;
        init(endArea, startTime);
    }



    public boolean isRunning() {
        return running;
    }
    public boolean isFinish() {
        return finish;
    }

    public int getStartTime() {
        return startTime;
    }

    public void startTask(Point nowPos) {
        running = true;
        startPoint = nowPos;
        endPoint = endArea.getRandomPoint();
        path = new Path(codv.gameScreen.gameStage.grids, startPoint, endPoint);
    }
    public Point act() {
        if(!running) return new Point(-1, -1);
        Point nextPoint = path.getNextPoint();
        if(nextPoint.equal(endPoint)) {
            running = false;
            finish = true;
        }
        return nextPoint;
    }
}
