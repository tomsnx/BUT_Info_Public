public class Rupture {
    public static void main(String[] args) {
        int[] tab = new int[]{1, 2, 5, 7, 2, 6, 0, 5, 2, 4, 6, 7, 8, 9, 3, 4, 6, 1, 2, 7, 8, 9, 4, 2, 3, 1, 5, 9, 7, 1, 6, 6, 3};

        int[] ruptures = ruptures(tab);

        afficheTab(ruptures);

        int[][] sequences = sequences(tab, ruptures);

        affiche2DTab(sequences);

        int[][] sequencesTrieesSP = triSequencesSelectionPermutation(sequences);
        affiche2DTab(sequencesTrieesSP);

        int[][] sequencesTrieesInsertion = triSequencesInsertion(sequences);
        affiche2DTab(sequencesTrieesInsertion);
    }

    /**
     * Renvoie un tableau contenant les indices de début des séquences de rupture
     * @param tab le tableau d'neiters
     * @return le tableau des indices de début de séquence (dans l'ordre initial)
     */
    public static int[] ruptures(int[] tab) {
        int cpt = 1;

        // parcours pour compter les ruptures et déterminer la taille du tableau
        for (int i = 1; i < tab.length; i++) {
            if (tab[i-1] >= tab[i]) {
                cpt++;
            }
        }

        int[] res = new int[cpt];
        res[0] = 0;
        int j = 1;

        for (int i = 1; i < tab.length; i++) {
            if (tab[i-1] >= tab[i]) {
                res[j] = i;
                j++;
            }
        }

        return res;
    }

    /**
     * renvoi un tableau en 2d dont i est la ième séquence
     * @param tab
     * @param ruptures
     * @return
     */
    public static int[][] sequences(int[] tab, int[] ruptures) {
        int[][] res = new int[ruptures.length][];

        for (int sequence = 0; sequence < ruptures.length - 1; sequence++) {
            int tailleSeq = ruptures[sequence+1] - ruptures[sequence];
            res[sequence] = new int[tailleSeq];

            for (int i = 0; i < tailleSeq; i++) {
                res[sequence][i] = tab[ruptures[sequence] + i];
            }
        }

        // on traite le dernier element
        int tailleLastSeq = tab.length - ruptures[ruptures.length - 1];
        res[ruptures.length - 1] = new int[tailleLastSeq];
        for (int i = 0; i < tailleLastSeq; i++) {
            res[ruptures.length - 1][i] = tab[ruptures[ruptures.length - 1] + i];
        }

        return res;
    }

    /**
     * Tri le tableau 2d donnée en paramètre par ordre de taille décroissant
     * @param sequences
     * @return
     */
    public static int[][] triSequencesSelectionPermutation(int[][] sequences) {
        int[][] sequencesTriees = new int[sequences.length][];
        for (int i = 0; i < sequencesTriees.length; i++) {
            sequencesTriees[i] = sequences[i].clone();
        }

        for (int i = 0; i < sequencesTriees.length; i++) {
            int max = i; // ou j
            for (int j = i; j < sequencesTriees.length; j++) {
                if (sequencesTriees[max].length < sequencesTriees[j].length) {
                    max = j;
                }
            }
            swap(i, max, sequencesTriees);
        }

        return sequencesTriees;
    }

    /**
     * tri
     * @param tab
     * @return
     */
    public static int[][] triSequencesInsertion(int[][] sequences) {
        int[][] tab = new int[sequences.length][];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = sequences[i].clone();
        }

        for (int i = 1; i < tab.length; i++) {
            int[] value = tab[i].clone();
            int place = i;

            while (place > 0 && value.length > tab[i-1].length) {
                tab[place] = tab[place-1].clone();
                place--;
            }
            tab[place] = value;
        }

        return tab;
    }

    /**
     * échange dans le tableau donnée en paramètre les valeurs aux indices x et y
     * @param x
     * @param y
     * @param tab
     */
    public static void swap(int x, int y, int[][] tab) {
        int[] tmp = tab[x].clone();
        tab[x] = tab[y];
        tab[y] = tmp;
    }

    /**
     * affiche le contenu du tableau 1D en paramètre
     * @param tab tableau à afficher
     */
    public static void afficheTab(int[] tab) {
        System.out.print("\t[" + tab[0]);
        for (int i = 1; i < tab.length; i++) {
            System.out.print(", " + tab[i]);
        }
        System.out.println("]");
    }

    /**
     * affiche le contenu du tableau 2D en paramètre
     * @param tab le tableau à afficher
     */
    public static void affiche2DTab(int[][] tab) {
        System.out.println("[");

        for (int i = 0; i < tab.length; i++) {
            afficheTab(tab[i]);
        }

        System.out.println("]");
    }
}
