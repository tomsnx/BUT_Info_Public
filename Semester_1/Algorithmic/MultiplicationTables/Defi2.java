public class Defi2 {

    /*
    * Retourne la position d'un point dans un cercle à l'aide de
    * la position actuelle du point et du nombre total de points.
    * Fonctionne dans le cas où l'on souhaite que les points 
    * soient équidistants.
    * @param ptActuel
    * @param nbTotal
    */
    static double[] positions(int ptActuel, int nbPtTotal, double scale){
        double[] tab = new double[2];
        double o = 2 * Math.PI / nbPtTotal;
        tab[0] = Math.cos(o * ptActuel)*scale;
        tab[1] = Math.sin(o * ptActuel)*scale;

        return tab;
    }

    /**
    * Affiche le numéro du points sur le cercle
    * @param points
    * @param n
    * @param i
    * @param scale
    */
    static void repPoints(double[][] points, int n, int i, double scale) {
    if (n < 33) {
        //Pour chaque point on récupère sa position
        double[] posTextActuel = positions(i, n, scale + 0.1);
        double xTextActuel = posTextActuel[0];
        double yTextActuel = posTextActuel[1];

        StdDraw.text(xTextActuel, yTextActuel, i + "");
    }
    }

    /**
    * Dessine les lignes des tables de multiplication
    * @param points
    * @param tt
    * @param b
    * @param n
    * @param scale
    */
    static void drawTT(double[][] points, double tt, int n, double scale) {
        StdDraw.setPenRadius(0.0015);
        for(int b = 0; b < n; b++) {
            double xCible = points[((int)tt * b)%n][0];
            double yCible = points[((int)tt * b)%n][1];
            
            //Pour chaque point on récupère sa position
            double[] posPointActuel = positions(b, n, scale);
            double xPtActuel = posPointActuel[0];
            double yPtActuel = posPointActuel[1];

            StdDraw.line(xPtActuel, yPtActuel, xCible, yCible);
        }
    }

    /**
    * Trace les points sur le cercle
    * @param points
    * @param n
    * @param scale
    */
    static void setPoints(double[][] points, int n, double scale) {

        // On trace les points
        for(int i = 0; i < n; i++) {

            StdDraw.setPenRadius(0.007);

            //Pour chaque point on récupère sa position
            double[] posPointActuel = positions(i, n, scale);
            double xPtActuel = posPointActuel[0];
            double yPtActuel = posPointActuel[1];

            points[i][0] = xPtActuel;
            points[i][1] = yPtActuel;

            StdDraw.point(xPtActuel, yPtActuel);
            repPoints(points, n, i, scale);
        }
    }

    /**
    * Anime le cercle en faisant varier n
    * @param points
    * @param tt
    * @param scale
    */
    static void animeTTn(double[][] points, int nmax, int tt, double scale) {
        int n = 0;
        while ( n < nmax) {
            n++;

            StdDraw.show();
            StdDraw.pause(16);
            StdDraw.clear();

            StdDraw.circle(0, 0, scale);
            setPoints(points, n, scale);
            repPoints(points, n, n, scale);
            drawTT(points, tt, n, scale);
        }
    }

    /**
     * Anime le cercle en faisant varier tt
     * @param points
     * @param n
     * @param tt
     * @param scale
     */
    public static void animeTTtt(double[][] points, int n, double tt, double scale, int refreshSpeed) {

        while (tt < 600) {
            tt += 1;

            StdDraw.show();
            StdDraw.pause(16);
            StdDraw.clear();

            StdDraw.setPenRadius(0.007);
            StdDraw.circle(0, 0, scale);
            setPoints(points, n, scale);
            repPoints(points, n, n, scale);
            drawTT(points, tt, n, scale);
        }
    }

    public static void main(String[] args) {
        // variables :
        int n = 200;
        double tt = 3;
        double scale = 0.95;

        //Sets
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-1.1, 1.1);
        StdDraw.setYscale(-1.1, 1.1);
        StdDraw.setPenColor(StdDraw.BLACK);

        double[][] points = new double[n][2];
        
        //Animation
        //animeTTn(points, nmax, tt, scale);
        animeTTtt(points, n, tt, scale, 16);
    }
}
