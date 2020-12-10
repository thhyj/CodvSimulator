package codv.Navagate;

import java.awt.*;
import java.util.Comparator;
import java.util.Random;

import codv.Point;

public class NavigatePoint extends Point {
    int dis;
    NavigatePoint parent;
    NavigatePoint(int x, int y, int x1, int y1, NavigatePoint parent) {
        super(x, y);
        dis = Math.abs(x1 - x) + Math.abs(y1 - y) ;
        this.parent = parent;
    }
    NavigatePoint(Point a, Point target, NavigatePoint parent) {
        super(a);
        dis = Math.abs(target.x - a.x) + Math.abs(target.y - a.y);
        this.parent = parent;
    }
    NavigatePoint(Point a, Point target) {
        super(a);
        dis = Math.abs(target.x - a.x) + Math.abs(target.y - a.y);
    }
   /* static Comparator<NavigatePoint> cPoint = new Comparator<NavigatePoint>() {
        @Override
        public int compare(NavigatePoint o1, NavigatePoint o2) {
            return o1.dis - o2.dis;
        }
    };*/
}
