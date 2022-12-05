import java.awt.Color;
import java.util.*;

public class Bresenham {

    /**
     * Trace des points  partir d'une liste de coordonnées passée en paramètre
     * @param list
     * @param color
     */
    public static void trace(List<int[]> list, Color color) {
        StdDraw.setPenColor(color);
        // int x;
        // int y;

        // for(int i = 0; i < list.size(); i++) {
        //     int[] tab = list.get(i);
        //     x = tab[0];
        //     y = tab[1];
        //     StdDraw.point(x, y);
        //     // OU StdDraw.point(list.get(i)[0], list.get(i)[1]);
        // }

        for (int[] point : list) {
            StdDraw.point(point[0], point[1]);
        }
    }

    public static List<int[]> cercle(int xc, int yc, int r) {
        List<int[]>pointList = new ArrayList<>();
        List<List<int[]>> listQi = new ArrayList<>();

        int x = 0;
        int y = r;
        int m = 5 - 4*r; // m = 4m dans la formule

        while(y >= x) {
            pointList.add(new int[]{xc - x, yc - y}); // Octant Q0
            pointList.add(new int[]{xc + x, yc + y}); // Octant Q1
            pointList.add(new int[]{xc - x, yc + y}); // Octant Q2
            pointList.add(new int[]{xc + y, yc + x}); // Octant Q3
            pointList.add(new int[]{xc - y, yc - x}); // Octant Q4
            pointList.add(new int[]{xc - y, yc + x}); // Octant Q5
            pointList.add(new int[]{xc + x, yc - y}); // Octant Q6
            pointList.add(new int[]{xc + y, yc - x}); // Octant Q7

            if(m > 0) {
                y--;
                m = m-8*y;
            }
            m += 8*x+12;
            x++;
        }
        return pointList;
    }

    public static void main(String[] args) {
        final int SIZE = 512;
        // 1 pixel par unité
        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(-SIZE/2, SIZE/2);
        StdDraw.setYscale(-SIZE/2, SIZE/2);

        List<int[]> lCercle1;
        List<int[]> lCercle2;
        lCercle1 = cercle(0,0,120);
        lCercle2 = cercle(100,50,80);

        trace(lCercle1, StdDraw.BLUE);
        trace(lCercle2, StdDraw.RED);
    }
}