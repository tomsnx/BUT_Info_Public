import javax.swing.plaf.synth.Region;

public class RingBuffer {
    private double[] buffer;
    private int first;
    private int last;
    private int capacity;
    private int size;

    /**
     * Constructeur
     * Prend en paramètre la capacité du buffer et l'initialise
     * @param capacity
     */
    public RingBuffer(int capacity){
        this.capacity = capacity;
        first = 0;
        last = 0;
        size = 0;
        buffer = new double[capacity];
    }

    /**
     * Affiche les attributs d’un RingBuffer ainsi que l’ensemble des valeurs rangées dans son buffer
     */
    public void display() {
        System.out.println();
        System.out.println("        ####### BUFFER #######      ");
        System.out.println();

        System.out.print("Buffer   : [");
        if (size() > 0) {
            System.out.print(buffer[first]);
            for (int i = (first+1)%capacity; (first < last) ? i < last : i != last;) {
                System.out.print(", " + buffer[i]);
                i = (i+1)%capacity;
            }
        }
        System.out.println("]");

        System.out.println("Capacity : " + capacity);
        System.out.println("Size     : " + size);
        System.out.println("First    : " + first);
        System.out.println("Last     : " + last);

        System.out.println();
        System.out.println("        ######################      ");
    }

    /**
     * Renvoie la taille du buffer
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Retourne vrai si le buffer est vide sinon faux
     * @return
     */
    public boolean isEmpty() {
        return size() <= 0;
    }

    /**
     * Retourne vrai si le buffer est plein sinon faux
     * @return
     */
    public boolean isFull() {
        return size() >= capacity;
    }

    /**
     * Ajoute un élément en queue de la file des éléments actifs
     * @param x
     */
    public void enqueue(double x) {
        if (isFull()) throw new RuntimeException("Erreur file pleine");

        buffer[last++] = x;
        last = last % capacity;
        size++;
    }

    /**
     * Supprime et retourne l’élément en tête de la file
     * @return
     */
    public double dequeue() {
        if (isEmpty()) throw new RuntimeException("Erreur file vide");
        
        double result = buffer[first++];
        first = first % capacity;
        size--;

        return result;
    }


    /**
     *  Retourne l’élément en tête de file des éléments actifs
     * @return
     */
    public double pick() {
        return buffer[first];
    }

    /**
    * méthode de debug
    */
    // public static void main(String[] args){
    //     RingBuffer buf = new RingBuffer(10);

    //     buf.enqueue(1.5);
    //     buf.enqueue(2.5);
    //     buf.enqueue(3.5);
    //     buf.enqueue(4.5);
    //     buf.enqueue(5.5);
    //     buf.enqueue(6.5);
    //     buf.enqueue(7.5);
    //     buf.enqueue(8.5);
    //     buf.enqueue(9.5);
    //     buf.enqueue(10);

    //     buf.dequeue();

    //     buf.enqueue(5555);

    //     buf.dequeue();

    //     buf.enqueue(151551);

    //     buf.dequeue();
    //     buf.dequeue();

    //     buf.enqueue(15981515);

    //     buf.display();
    // }
}
