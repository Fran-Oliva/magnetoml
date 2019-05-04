package Business.Searches;

import org.junit.Test;

import static org.junit.Assert.*;

public class HorizontalTest {
    @Test
    public void horizontalSearch() throws Exception {
        String[] dnaMatrizStr = {"ATTCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        char[][] matrizChar = new char[dnaMatrizStr.length][dnaMatrizStr.length];
        for (int i = 0; i < dnaMatrizStr.length; i++) {
            String palabra = dnaMatrizStr[i];
            for (int j = 0; j < palabra.length(); j++) {
                matrizChar[i][j] = palabra.charAt(j);
            }
        }
        Horizontal horizontal = new Horizontal();
        int result = horizontal.horizontalSearch(matrizChar);
        assertTrue(result==1);
    }
}