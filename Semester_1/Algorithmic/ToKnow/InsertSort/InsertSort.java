
public class InsertSort {

    public static void afficheTab(int[] tab) {
        System.out.print("[ ");
        for(int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.print(tab[tab.length-1]);
        System.out.print(" ]");
    }

    public static int[] insertSort1D(int[] tab) {

        for(int i = 1; i < tab.length; i++) {
            int x = tab[i];
            int j = i;
            while(j > 0 && tab[j - 1] > x) {
                tab[j] = tab[j - 1];
                j--;
            }
            tab[j] = x;
        }
        return tab;
    }

    public static void main(String[] args) {

        int[] tab = { 11, 2, 6, 7, 3, 9, 10, 5};

        afficheTab(insertSort1D(tab));
    }
}