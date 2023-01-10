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

    /**
     * Trace 2 diagonales d'épaisseur e dans l'image
     * @param imgIn image d'entrée
     * @param e epaisseur des diagonales
     * @return image avec les diagonales tracées
     */
    public static byte[][] traceDiagos(byte[][] imgIn, int e) {
        final int I_DIM = imgIn.length;
        final int J_DIM = imgIn[0].length;

        byte[][] imgOut = new byte[I_DIM][J_DIM];
        
        for(int i = 0; i < I_DIM; i++) {
            for(int j = 0; j < J_DIM; j++) {
                imgOut[i][j] = imgIn[i][j];
            }
        }

        for(int i = 0; i < I_DIM; i++) {
            for(int j = 0; j < J_DIM; j++) {
                if(i == j || i == I_DIM - j) {
                    for(int k = 0; k < e; k++) {
                        if(i + k < I_DIM && j + k < J_DIM) {
                            imgOut[i + k][j + k] = 0;
                        }
                        if(i - k >= 0 && j - k >= 0) {
                            imgOut[i - k][j - k] = 0;
                        }
                        if(i + k < I_DIM && j - k >= 0) {
                            imgOut[i + k][j - k] = 0;
                        }
                        if(i - k >= 0 && j + k < J_DIM) {
                            imgOut[i - k][j + k] = 0;
                        }
                    }
                }
            }
        }
        return imgOut;
    }

    public static byte[][] averageFilter2D(byte[][] imgIn, int filterSize) {
        byte[][] imgOut = imgIn;
        final int I_DIM = imgOut.length;
        final int J_DIM = imgOut[0].length;
        int marge = (int)(filterSize / 2);
        double sum;

        for(int i = 0; i < I_DIM; i++) {
            for(int j = 0; j < J_DIM; j++) {
                if(i < marge && j < marge) {
                    /* Prend le carré pour faire la moyenne */
                    for(posY = i - marge; posY < filterSize; posY++) {
                        for(posX = j - marge; posY < filterSize; posY++) {
                            sum += imgOut[posX][posY];
                        }
                    }
                } else {
                    /* Prend le carré pour faire la moyenne */
                    for(posY = i - marge; posY < filterSize; posY++) {
                        for(posX = j - marge; posY < filterSize; posY++) {
                            sum += imgOut[posX][posY];
                        }
                    }
                }
            }
        }
    
                
                sum
            }
        }

        return imgOut;
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
        for(int i = 0; i < img.height; i++)
            for(int j = 0; j < img.width; j++)
                imgIn[i][j] = img.data[i * img.width + j] ;

        /*
        * Appels aux fonctions de traitement
        */
        //imgOut = traceCadre(imgIn, 3);
        //imgOut = traceDiagos(imgIn, 3);
	
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

