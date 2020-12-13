package codv.Navagate;


import codv.Actors.Grids.Grid;

import java.util.*;
import java.util.List;

import codv.Point;


public class Path {
    private Grid[][] grids;
    private LinkedList<Point> path;
    private Iterator<Point> iter;
    static private final Point[] direction = {new Point(0, 1),
            new Point(1, 0), new Point(0, -1), new Point(-1, 0)
    };
    private Point st;
    private Point ed;

    public Path(Grid[][] grids, Point st, Point ed) {
        this.grids = grids;
        path = new LinkedList<Point>();
        this.st = st;
        this.ed = ed;
        aStar(new Point(st), new Point(ed));
    }
    private void aStar(Point start, Point end) {
        ++Grid.nowId;
        Comparator<NavigatePoint> cPoint = new Comparator<NavigatePoint>() {
            @Override
            public int compare(NavigatePoint o1, NavigatePoint o2) {
                return o1.dis - o2.dis;
            }
        };
        PriorityQueue<NavigatePoint> heap = new PriorityQueue<NavigatePoint>(cPoint);
        heap.add(new NavigatePoint(start, end, new NavigatePoint(start, end)));
        Point nextPoint;
        int tot = 0;
        while(true) {
            ++tot;
            NavigatePoint now = heap.poll();
            if(now.equal(end)) {
       //         System.out.println("tot = "+tot);
                while(true) {
                    path.addFirst(new Point(now.x, now.y));
                    if(now.equal(now.parent)) {
                        break;
                    }
                    now = now.parent;
                }
                iter = path.iterator();
                heap.clear();
                return;
            }
            List<Integer> random = new ArrayList<Integer>();
            random.add(0);
            random.add(1);
            random.add(2);
            random.add(3);
            Collections.shuffle(random);
            for(int i = 0; i < 4; ++i) {
                nextPoint = now.add(direction[random.get(i)]);
                if(nextPoint.islegal()) {
                    if(grids[nextPoint.x][nextPoint.y].passable()) {
                        if(grids[nextPoint.x][nextPoint.y].id != Grid.nowId) {
                            heap.add(new NavigatePoint(nextPoint,end, now));
                            grids[nextPoint.x][nextPoint.y].id = Grid.nowId;
                        }
                    }
                }
            }
        }
    }
    public Point getNextPoint() {
        if(iter.hasNext()) {
          return iter.next();
        } else {
            return new Point(-1, -1);
        }
    }
}
