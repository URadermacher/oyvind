package eu.vdrm;


import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.BlockRealMatrix;

import java.io.IOException;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("Unchecked")
    public static void main(String[] args) throws IOException, PythonExecutionException {
        System.out.println( "Hello World!" );

        Complex[][] in = new Complex[2][2];
        in[0][0] = new Complex(1,2);
        in[0][1] = new Complex(3,4);
        in[1][0] = new Complex(5,6);
        in[1][1] = new Complex(7,8);
        Array2DRowFieldMatrix<Complex> mm = new Array2DRowFieldMatrix(in);
        printMatrix(mm);


        Complex[][] ad = new Complex[2][2];
        ad[0][0] = new Complex(9,10);
        ad[0][1] = new Complex(11,12);
        ad[1][0] = new Complex(13,14);
        ad[1][1] = new Complex(15,16);
        Array2DRowFieldMatrix<Complex> nn = new Array2DRowFieldMatrix(ad);
        printMatrix(nn);


        Array2DRowFieldMatrix<Complex> oo = mm.add(nn);
        printMatrix(oo);


        Plot plt = Plot.create();
        plt.plot()
                .add(Arrays.asList(1.3, 2))
                .label("label")
                .linestyle("--");
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();


    }

    private static void printMatrix(Array2DRowFieldMatrix<Complex> mm) {
        int rows = mm.getRowDimension();
        int cols = mm.getColumnDimension();
        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                sb.append(mm.getEntry(r,c)).append("  ");
            }
            System.out.println(sb.toString());
        }
    }
}
