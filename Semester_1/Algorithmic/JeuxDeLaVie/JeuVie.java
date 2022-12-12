import java.util.Scanner;
import java.util.Random;

public class JeuVie {
    static final Scanner input = new Scanner(System.in);
    static final Random rand = new Random();
  
    enum Cell{DEAD, ALIVE}
    int size ;
    private Cell[][] ecosysteme ;
    int[][] voisines ;
  
    /**
     * Renvoie vrai avec une probabilité p
     * @param p la probabilité de tirage vrai souhaitée
     * @return  le tirage vrai ou faux
     */
    public boolean tireProba(double p){
        return (rand.nextDouble() < p);
    }

    /**
     * Affiche l'écosysteme de Cell dans le terminal
     * @param tab
     */
    public void displayCellTerm() {
        System.out.print("[ ");
        for(int i = 0; i < ecosysteme.length; i++) {
            System.out.print("[ ");
            for(int j = 0; j < ecosysteme[i].length; j++) {
                System.out.print(ecosysteme[i][j] + ", ");
            }
            System.out.print("]");
            if(i < ecosysteme.length - 1) {
                System.out.println();
            }
        }
        System.out.print(" ]");
    }

    /**
     * Affiche l'écosysteme de Cell dans une fenêtre graphique
     * @param tab
     */
    public void displayCellGraphical() {
        for(int i = 0; i < ecosysteme.length; i++) {
            for(int j = 0; j < ecosysteme[i].length; j++) {
                //StdDraw.pause(8);
                if(ecosysteme[i][j] == Cell.ALIVE) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(i + 0.5, j + 0.5, 0.5);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                if(size <= 25) {
                    StdDraw.text(i + 0.5, j + 0.5, Integer.toString(nbVoisines(i, j)));
                }
            } 
        }
    }

    public int nbVoisines(int i, int j) {
        int nbVoisines = 0;
        for(int line = i - 1; line < i + 2; line++) {
            for(int column = j - 1; column < j + 2; column++) {
                if((line != i || column != j) && (ecosysteme[(line + size)%size][(column + size)%size] == Cell.ALIVE)) {
                    nbVoisines++;
                }
            }
        }
        return nbVoisines;
    }

    /**
     * Effectue une itération et calcule l’état de cellule pour la génération suivante 
     * @return
     */
    public int nextGen() {
        int chEtat = 0;
        voisines = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                voisines[i][j] = nbVoisines(i, j);
            }
        }

        for(int i = 0; i < voisines.length; i++) {
            for(int j = 0; j < voisines[i].length; j++) {
                if(voisines[i][j] < 2 || voisines[i][j] > 3) {
                    ecosysteme[i][j] = Cell.DEAD;
                    chEtat++;
                } else if(voisines[i][j] == 3){
                    ecosysteme[i][j] = Cell.ALIVE;
                    chEtat++;
                }
            }
        }

        return chEtat;
    }

    /**
     * Constructeur d'un jeu de la vie de taille n.
     * Initialisé avec nxn cellules dont p% sont vivantes
     * @param size la taille du coté de l'écosystème
     */
    public JeuVie(int size, double p){
        this.size = size;
        this.ecosysteme = new Cell[size][size];

        for(int i = 0; i < ecosysteme.length; i++) {
            for(int j = 0; j < ecosysteme[i].length; j++) {
                if(tireProba(p)) {
                    ecosysteme[i][j] = Cell.ALIVE;
                } else {
                    ecosysteme[i][j] = Cell.DEAD;
                }
            }
        }
    }

    public static void main(String [] args) {
        final double PROBA = 0.5; // Pour l'initialisation
        char restart;

        do {
            int size; // Taille de l'écosystème
            int nb; // nombre de générations à sauter entre deux affichages
            int gen = 0; // numéro de la génération courante
            int cpt; // compteur de générations à sauter entre deux affichages
            int ch;  // nombre de changements d'une génération à l'autre
            int tmpCh = 0;
            int tmpGen = 0;

            System.out.print("Taille de l'ecosystème : ");
            size = input.nextInt();
            System.out.print("Nombre de génération à sauter : ");
            nb = input.nextInt();

            StdDraw.enableDoubleBuffering();
            StdDraw.setCanvasSize(600, 600);
            StdDraw.setScale(0, size);

            JeuVie jeu = new JeuVie(size, PROBA);

            do {
                cpt = nb;
    
                do {
                    ch = jeu.nextGen();
                    cpt--;
                } while (cpt > 0);
    
                StdDraw.clear();
                jeu.displayCellGraphical();
                StdDraw.pause(8);
                StdDraw.show();
    
                gen += nb;

                if(tmpCh == ch) {
                    tmpGen++;
                }
                tmpCh = ch;
                if(tmpGen == 50 ) {
                    break;
                }
            } while(ch != 0);
            System.out.println("Nombre de générations totales : " + gen);

            System.out.print("Souhaitez-vous rejouer ? (o/n) ");
            restart = input.next().charAt(0);
        } while(restart == 'o');
    }
  }