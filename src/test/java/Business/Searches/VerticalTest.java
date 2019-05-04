package Business.Searches;

import org.junit.Test;

import static org.junit.Assert.*;

public class VerticalTest {
    @Test
    public void verticalSearch() throws Exception {
        String[] dnaMatrizStr = {"ATTCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        char[][] matrizChar = new char[dnaMatrizStr.length][dnaMatrizStr.length];
        for (int i = 0; i < dnaMatrizStr.length; i++) {
            String palabra = dnaMatrizStr[i];
            for (int j = 0; j < palabra.length(); j++) {
                matrizChar[i][j] = palabra.charAt(j);
            }
        }
        Vertical vertical = new Vertical();
        int result = vertical.verticalSearch(matrizChar);
        assertTrue(result==1);
    }

}