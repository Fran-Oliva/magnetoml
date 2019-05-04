package Business.Searches;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObliqueTest {
    @Test
    public void obliqueSearch() throws Exception {
        String[] dnaMatrizStr = {"ATTCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        char[][] matrizChar = new char[dnaMatrizStr.length][dnaMatrizStr.length];
        for (int i = 0; i < dnaMatrizStr.length; i++) {
            String palabra = dnaMatrizStr[i];
            for (int j = 0; j < palabra.length(); j++) {
                matrizChar[i][j] = palabra.charAt(j);
            }
        }
       Oblique oblique = new Oblique();
        int result = oblique.obliqueSearch(matrizChar);
        assertTrue(result==1);
    }

}