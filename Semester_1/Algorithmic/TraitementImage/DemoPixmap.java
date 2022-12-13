import java.io.IOException;

/**
 * Created by zulupero on 09/11/15.
 */
public class DemoPixmap {

    public static byte[][] traceCadre(byte[][] imgIn, int e){
        final int I_DIM = imgIn.length ;
        final int J_DIM = imgIn[0].length ;
        final int WHITE = 255;
        final int BLACK = 0;

        byte[][] imgOut = new byte[I_DIM][J_DIM] ;
        
        for(int i = 0; i < I_DIM; i++) {
            for(int j = 0; j < J_DIM; j++) {
                imgOut[i][j] = (byte)(WHITE - imgIn[i][j]);
                if(i < e) {
                    imgOut[i][j] = (byte)BLACK;
                }
                if(i <= I_DIM && i > I_DIM - e) {
                    imgOut[i][j] = (byte)BLACK;
                }
                if(j < e) {
                    imgOut[i][j] = (byte)BLACK;
                }
                if(j <= J_DIM && j > J_DIM - e) {
                    imgOut[i][j] = (byte)BLACK;
                }
            }
        }

        return imgOut ;
    }

    public static void traceDiago(byte[][] imgIn, int e) {
        final int I_DIM = imgIn.length ;
        final int J_DIM = imgIn[0].length ;

        for(int i = 0; i < I_DIM; i++) {
            for(int j = 0; j < J_DIM; j++) {
                if(j == i) {
                    imgIn[i][j] = (byte)(0);
                }
            }
        }

        for(int i = I_DIM - 1; i != 0; i--) {
            for(int j = J_DIM - 1; j != 0; j--) {
                if(j == i) {
                    imgIn[i][j] = (byte)(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        BytePixmap img;
        try {
            img = new BytePixmap(args[0]);         // lecture du fichier
        } catch (IOException e) { img = null; System.exit(0); }
        System.out.println("image lue : "+ img.height+"x"+img.width);

        byte[][] imgIn = new byte[img.height][img.width] ;
        byte[][] imgOut;

         /*
         * image 1D dans imgIn 2D
         */
        for(int i=0; i< img.height; i++)
            for(int j=0; j<img.width; j++)
                imgIn[i][j] = img.data[i * img.width + j] ;

        /*
        * Appels aux fonctions de traitement
        */
        imgOut = traceCadre(imgIn, 3);
        traceDiago(imgOut, 3);
	
        /*
         * imgIn 2D dans img 1D
         */
        for(int i=0; i< img.height; i++)
            for(int j=0; j<img.width; j++)
                img.data[i*img.width + j] = imgOut[i][j] ;

	    // écriture de l'image de sortie
        img.write("neg_"+args[0]);                
        }
}

