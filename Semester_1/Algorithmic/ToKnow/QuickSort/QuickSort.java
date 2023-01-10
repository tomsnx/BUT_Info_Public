
public class QuickSort{

    /**
     * Affiche un tableau d'entier 1D
     * @param tab
     */
    public static void afficheTab(int[] tab) {
        System.out.print("[ ");
        for(int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.print(tab[tab.length - 1]);
        System.out.print(" ]");
    }

    /**
     * Echange 2 variables de position
     * @param t
     * @param m
     * @param n
     */
    static void echangerElements(int[] t, int m, int n) {
        int temp = t[m];
    
        t[m] = t[n];
        t[n] = temp;
      }
    
      /**
       * Partitionne le tableau
       * @param t
       * @param m
       * @param n
       * @return
       */
      static int partition(int[] t, int m, int n) {
        int v = t[m];                 // valeur pivot
        int i = m-1;
        int j = n+1;                  // indice final du pivot
    
        while (true) {
          do {
            j--;
          } while (t[j] > v);
          do {
            i++;
          } while (t[i] < v);
          if (i<j) {
            echangerElements(t, i, j);
          } else {
            return j;
          }
        }
      }
    
      /**
       * Exécute le QuickSort
       * @param t, m(nombre de départ du tri), n(dernier nombre ou s'arrête le tri)
       */
      static void quickSort(int[] t, int m, int n) {
        if (m<n) {
          int p = partition(t, m, n);
          quickSort(t, m, p);
          quickSort(t, p+1, n);
        }
      }
    
    public static void main(String [] args) {
        int[] tab = { 11, 2, 6, 7, 3, 9, 10, 5 };
        quickSort(tab, 0, tab.length - 1);
        afficheTab(tab);
    }
}