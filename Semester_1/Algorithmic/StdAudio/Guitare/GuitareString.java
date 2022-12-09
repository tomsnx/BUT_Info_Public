import java.util.Random;
import java.util.*;

public class GuitareString {

    final Random RANDOM = new Random();
    final double ATTN = 0.994;
    final static private Scanner scanner = new Scanner(System.in);
    int toc = 0;
    int n;

    private double frequency;
    private RingBuffer buffer;

    /**
     * Constructeur
     * Prend en paramètre la fréquence fondamentale f0
     * @param frequency
     */
    public GuitareString(double frequency) {
        this.frequency = frequency;
        n = (int)((StdAudio.SAMPLE_RATE/frequency+(1/2)) + 0.5f);
        buffer = new RingBuffer(n);
    }

    /**
     * initialise le contenu du buffer avec du bruit blanc
     */
    public void pluck() {
        double rdm;
        while(!buffer.isFull()) {
            rdm = -0.5 + (0.5 - (-0.5)) * RANDOM.nextDouble();
            buffer.enqueue(rdm);
        }
    }

    /**
     * Réalise un pas de simulation
     */
    public void tic() {
        double result;
        toc++;

        result = buffer.dequeue();
        result += buffer.pick();
        result = (result / 2) * ATTN;
        buffer.enqueue(result);
    }

    /**
     * Retourne simplement le prochain échantillon à envoyer sur la sorte audio
     * @return
     */
    private double sample() {
        return buffer.pick();
    }

    /**
     * Retourne le nombre de pas de simulation qui
     * ont été effectués depuis le début de la simulation
     * @return
     */
    private int time() {
        return toc;
    }

    public static void afficheTab(String[] tab) {
        System.out.print("[ ");
        for(int i = 0; i < tab.length; i++) {
            System.out.print(tab[i]+", ");
        }
        System.out.print(" ]");
    }

    public static GuitareString[] guitareStringTab(String clavier) {
        GuitareString[] guitareTab = new GuitareString[clavier.length()];

        // Initialise un tableau de GuitareString avec clavier.length() éléments
        for(int i = 0; i < clavier.length(); i++) {
            GuitareString guitare = new GuitareString(Math.pow(2, (i-24)/12.0)*1000);
            guitare.pluck();
            guitareTab[i] = guitare;
        }

        return guitareTab;
    }

    public static void resetGuitare(GuitareString[] guitareTab, int index) {
        guitareTab[index] = new GuitareString(Math.pow(2, (index-24)/12.0)*1000);
        guitareTab[index].pluck();
    }
   

    public static void main(String[] args) {
        //double f0 = 440.0;

        // Variables
        String clavier = "abcdefghijkl";
        GuitareString[] guitareTab = guitareStringTab(clavier); 

        // Joue le tableau de GuitareString
        while(true) {
            GuitareString guitare;
            String[] clavierTab = clavier.split("");
            afficheTab(clavierTab);

            String touche = scanner.nextLine();

            // Boucle sur chaque lettre du clavier pour vérifier
            //si l'entrée utilisateur est dans le clavier
            for(int j = 0; j < clavier.length(); j++) {
                if(clavierTab[j].equals(touche)) {
                    guitare = guitareTab[j];
                    while(guitare.time() < 10000) {
                        StdAudio.play(guitare.sample());
                        guitare.tic();
                    }
                    resetGuitare(guitareTab, j);
                }
            }
        }
    }
}