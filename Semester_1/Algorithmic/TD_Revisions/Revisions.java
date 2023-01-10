
public class Revisions {


    /**
     * Affiche les éléments significatifs du tableau.
     * Ces éléments sont déterminés grâce au chiffre contenu dans la première cellule de celui çi.
     * @param tab
     */
    public static void affiche(int[] tab) {
        if(taille(tab) != 0) {
            System.out.print("[ ");
            for(int i = 1; i < taille(tab); i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.print(tab[taille(tab)]);
            System.out.println(" ]");
        } else {
            System.out.println("Tableau vide");
        }
        
    }

    /**
     * Retourne le nombre d'éléments significatifs du tableau (soit la taille)
     * Ici ce nombre correspond au contenu de la première cellule.
     * @param tab
     * @return
     */
    public static int taille(int[] tab) {
        return tab[0];
    }

    /**
     * Retourne true si le tableau est vide sinon false
     * @param tab
     * @return
     */
    public static boolean estVide(int[] tab) {
        boolean result = false;
        if(taille(tab) == 0) {
            result = true;
        }
        return result;
    }

    /**
     * Retourne true si le tableau est plein sinon false
     * @param tab
     * @return
     */
    public static boolean estPlein(int[] tab) {
        boolean result = false;
        if(taille(tab) + 1 == tab.length) {
            result = true;
        }

        return result;
    }

    /**
     * Initialise le tableau
     * @param tab
     * @param k
     */
    public static void initialise(int[] tab, int k) {
        for(int i = 1; i <= k; i++) {
            tab[i] = i;
        }
        tab[0] = k;
    }

    /**
     * Retourne l'indice de l'élément x dans le tableau
     * @param tab
     * @param x
     * @return
     */
    public static int indice(int[] tab, int x) {
        int i = 1;
        while(i <= taille(tab) && tab[i] <= x) {
            if(tab[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Supprime le dernier élément du tableau
     * @param tab
     * @param x
     */
    public static void supprimeFin(int[] tab) {
        if(!estVide(tab)) {
            tab[0]--;
        }
    }

    /**
     * Ajoute à la fin du tableau l'élément x en veillant à ce qu'il reste trié
     * @param tab
     * @param x
     */
    public static void ajoutFin(int[] tab, int x) {
        if(!estPlein(tab) && x >= tab[taille(tab)]) {
            tab[0]++;
            tab[taille(tab)] = x;
        }
    }

    /**
     * Décale vers la gauche ma tranche tab[i], ... , tab[j]
     * @param tab
     * @param i
     * @param j
     */
    public static void decaleGauche(int[] tab, int i, int j) {
        for(int p = i; p <= j; p++) {
            tab[p-1] = tab[p];
        }
    }

    public static void main(String [] args) {
        int[] tab = { 5, 12, 5, 9, 10, 0, 3 };
        affiche(tab);
        decaleGauche(tab, 2, 4);
        affiche(tab);
    }
}