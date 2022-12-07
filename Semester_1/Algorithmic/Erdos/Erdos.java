public class Erdos {

    public static boolean bernoulli(double p) {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("p must be between 0 and 1");
        }
        return Math.random() < p;
    }
    
    public static void main(String[] args) {
        int n = 16;
        double p = 1;
        StdDraw.setXscale(-1.1, 1.1);
        StdDraw.setYscale(-1.1, 1.1);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.setPenRadius(0.02);
            double x = Math.cos(2 * Math.PI * i / n);
            double y = Math.sin(2 * Math.PI * i / n);
            StdDraw.point(x, y);
            for (int j = 0; j < i; j++) {
                StdDraw.setPenRadius(0.002);
                double x2 = Math.cos(2 * Math.PI * j / n);
                double y2 = Math.sin(2 * Math.PI * j / n);
                if (bernoulli(p)) {
                    StdDraw.line(x, y, x2, y2);
                }
            }
        }
    }
}
