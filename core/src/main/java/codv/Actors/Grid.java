package codv.Actors;

import codv.Codv;
import codv.Point;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * 格子，区块(空地，墙壁)的基类
 * type 0 空地
 * type 1 墙
 * type 2 室内
 * type 3 绿化
 */
public class Grid extends Actor {

    private Codv codv;
    //存着所有格子的那个数组的别名
    private Grid[][] grids;
    //代表邻接四个方向的坐标变化，上右下左
    static private final Point[] direction = {new Point(0, 1),
    new Point(1, 0), new Point(0, -1), new Point(-1, 0)
    };
    //区块的坐标，需要注意的是，格子的坐标是以左下角为(0,0)，向右为x轴正方向，向上为y轴正方向
    protected Point position;
    //人是否能通过
    private boolean passable;
    //当前的病毒浓度
    protected double virusConcentration, lastVirusConcentration;
    //这个区块的病毒留存率和扩散率
    protected double retentionRate, diffusionRate;

    protected Sprite image;

    protected Color color;

    public int type, id = 0;
    static public int nowId = 0;
    public Grid(Codv codv,Grid[][] grids, Point position) {
        this.codv = codv;
        this.grids = grids;
        this.position = position;
        this.setSize(10f,10f);
        this.setPosition(position.x, position.y);
        image = new Sprite((Texture) codv.manager.get("block.png"));
        image.setSize(10f, 10f);
        addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                 System.out.println("tx = " + position.x + " ty = " + position.y);
                super.clicked(event, x, y);
            }
        });
    }

    public boolean isPassable() {
        return passable;
    }
    public double getVirusConcentration() {
        return virusConcentration;
    }
    public void setVirusConcentration(double rate) {
        virusConcentration = rate;
    }
    public void addVirusConcentration(double rate) {
        virusConcentration += rate;
    }
    public boolean passable() {
        return type == 0 || type == 2;
    }
    public boolean diffusiable() {
        return type == 0 || type == 2 || type == 3;
    }

    /**
     * 每一帧这个格子对自己和周围格子所发生的的改变都在run里执行，
     * 先对自己格子的病毒浓度进行留存更新，然后对周围格子进行扩散更新
     * 如果周围的一个格子扩散不了，那么原本该扩散出去到那个格子的病毒就留下来
     * 这里采用四联通邻接方式
     * 值得注意的是，调用run之前要保证对所有的格子进行virusConcentration的清零
     */
    public void run() {
        virusConcentration += lastVirusConcentration * retentionRate;
        Point adjacentPoint;
        Grid tempGrid;
        for(int t = 0; t < 4; ++t) {
            adjacentPoint = position.add(direction[t]) ;
            if(adjacentPoint.islegal()) {
                tempGrid = grids[adjacentPoint.x][adjacentPoint.y];
                if(tempGrid.diffusiable()) {
                    grids[adjacentPoint.x][adjacentPoint.y].
                            addVirusConcentration( lastVirusConcentration * diffusionRate);
                } else {
                    virusConcentration += lastVirusConcentration * diffusionRate;
                }
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        run();
        image.setColor(color);
        image.setPosition(getX(), getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        image.draw(batch);
    }
}
