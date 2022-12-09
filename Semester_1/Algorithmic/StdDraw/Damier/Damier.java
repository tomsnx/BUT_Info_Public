import java.util.*;

public class Damier {

    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;

        do {
            System.out.print("Entrez n : ");
            n = input.nextInt();
        } while (n <= 0);

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        drawDamier(n);
    }

    public static void drawDamier(int n) {
        for (int i = 1; i <= n; i++) {
            boolean odd = !(i % 2 == 0.0);

            for (int j = 1; j <= n; j++) {
                if (j % 2 == 0.0) {
                    changeColor(odd);
                } else {
                    changeColor(!odd);
                }

                StdDraw.filledSquare(j, i, 1);
            }
        }
    }

    public static void changeColor(boolean odd) {
        if (odd) {
            StdDraw.setPenColor(255, 0, 0);
        } else {
            StdDraw.setPenColor(0, 0, 0);
        }
    }
}
