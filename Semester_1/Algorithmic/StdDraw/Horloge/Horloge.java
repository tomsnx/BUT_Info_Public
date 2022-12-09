import java.util.*;

public class Horloge {

    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        StdDraw.setXscale(-1.4, 1.4);
        StdDraw.setYscale(-1.4, 1.4);

        StdDraw.enableDoubleBuffering();

        while (true) {
            drawBaseHorloge();

            computeTimeUnits();

            StdDraw.show();
            StdDraw.pause(100);
        }
    }

    public static void drawBaseHorloge() {
        int n = 12;

        StdDraw.clear(StdDraw.WHITE);

        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledCircle(0, 0, 1.1);

        StdDraw.setPenColor(0, 0, 255);

        double space = 2.0*Math.PI / n;
        
        double[][] points = new double[n][2];

        int counter = 0;
        for (double i = 0.0; i < 2.0*Math.PI; i += space, counter++) {
            double x = Math.cos(i);
            double y = Math.sin(i);

            StdDraw.filledCircle(x, y, .05);

            points[counter][0] = x;
            points[counter][1] = y;
        }
    }

    public static void computeTimeUnits() {
        double hours = (double) Calendar.getInstance().get(Calendar.HOUR);
        double minutes = (double) Calendar.getInstance().get(Calendar.MINUTE);
        double secondes = (double) Calendar.getInstance().get(Calendar.SECOND);

        hours += (minutes*100/60)/100 + (secondes*100/60)/1000; // on rajoute les minutes + secondes dans les heures pour un angle plus précis
        minutes += (secondes*100/60)/100;

        final double ANGLE = 90.0;

        hours = -1 * (hours * (2.0*Math.PI) / 12.0) + Math.toRadians(ANGLE); // format 12h en format 2pi
        minutes = -1 * (minutes * (2.0*Math.PI) / 60.0) + Math.toRadians(ANGLE); // format 60 min en format 2pi
        secondes = -1 * (secondes * (2.0*Math.PI) / 60.0) + Math.toRadians(ANGLE); // format 60 sec en format 2pi

        drawAiguilleHeure(hours);
        drawAiguilleMinute(minutes);
        drawAiguilleSeconde(secondes);
    }

    public static void drawAiguilleHeure(double heure) {
        double LENGTH = .5;

        double x = Math.cos(heure) * LENGTH;
        double y = Math.sin(heure) * LENGTH;

        StdDraw.setPenColor(255, 255, 255);
        StdDraw.setPenRadius(0.015); // default 0.002
        StdDraw.line(0, 0, x, y);
    }

    public static void drawAiguilleMinute(double minutes) {
        double LENGTH = .7;

        double x = Math.cos(minutes) * LENGTH;
        double y = Math.sin(minutes) * LENGTH;

        StdDraw.setPenColor(128, 128, 128);
        StdDraw.setPenRadius(0.01); // default 0.002
        StdDraw.line(0, 0, x, y);
    }

    public static void drawAiguilleSeconde(double secondes) {
        double LENGTH = .9;

        double x = Math.cos(secondes) * LENGTH;
        double y = Math.sin(secondes) * LENGTH;

        StdDraw.setPenColor(255, 255, 0);
        StdDraw.setPenRadius(0.006); // default 0.002
        StdDraw.line(0, 0, x, y);
    }
}
