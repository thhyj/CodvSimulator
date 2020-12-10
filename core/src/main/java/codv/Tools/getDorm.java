package codv.Tools;

import codv.Point;

public class getDorm extends Point{
    public getDorm(int id) {
        super();
        y -= (id & 1);
        id /= 6;
        if(id < 60) {
            x += id % 10 * 2 + 3;
            y += id / 10 * 4 + 72;
        } else {
            id -= 60;
            x += id % 10 * 2 + 3;
            y += id / 10 * 4 + 5;
        }
    }
}
