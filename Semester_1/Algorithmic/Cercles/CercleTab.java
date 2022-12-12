import java.awt.Color;
import java.util.*;

public class CercleTab {
    public static void main(String[] args) {
        final int SIZE = 512;
        // 1 pixel par unité
        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(-SIZE/2, SIZE/2);
        StdDraw.setYscale(-SIZE/2, SIZE/2);

        List<List<int[]>> lCercle1;
        List<List<int[]>> lCercle2;
        lCercle1 = cercle(0,0,120);
        lCercle2 = cercle(100,50,80);

        trace(lCercle1, StdDraw.BLUE);
        trace(lCercle2, StdDraw.RED);
    }

    public static List<List<int[]>> cercle(int xc, int yc, int r) {
        List<List<int[]>> wholeCircle = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            wholeCircle.add(new ArrayList<>());
        }

        int x = 0;
        int y = r;
        int _4m = 5 - 4*r;

        while (y >= x) {
            wholeCircle.get(0).add(new int[]{xc + y, yc + x}); // Q0
            wholeCircle.get(1).add(new int[]{xc + x, yc + y}); // Q1
            wholeCircle.get(2).add(new int[]{xc - x, yc + y}); // Q2
            wholeCircle.get(3).add(new int[]{xc - y, yc + x}); // Q3
            wholeCircle.get(4).add(new int[]{xc - y, yc - x}); // Q4
            wholeCircle.get(5).add(new int[]{xc - x, yc - y}); // Q5
            wholeCircle.get(6).add(new int[]{xc + x, yc - y}); // Q6
            wholeCircle.get(7).add(new int[]{xc + y, yc - x}); // Q7

            if (_4m > 0) {
                y--;
                _4m -= 8*y;
            }
            _4m += 8*x + 12;

            x++;
        }

        return wholeCircle;
    }

    public static void trace(List<List<int[]>> liste, Color color) {
        StdDraw.setPenColor(color);

        int i = 0;
        for (List<int[]> q : liste) {
            if (i++ % 2 == 1) Collections.reverse(q);
            for (int[] point : q) {
                StdDraw.point(point[0], point[1]);
                StdDraw.pause(1);
            }
        }
    }
}
