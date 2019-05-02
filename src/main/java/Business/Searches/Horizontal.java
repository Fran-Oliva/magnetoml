package Business.Searches;

public class Horizontal {

    String root="";
    char letter;
    int validSequence = 4;
    int equalLetterFoundHorizontal = 0;
    int totalSequenceFound =0;

    public int horizontalSearch(char[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                root = i + "," + j;
                letter = m[i][j];
                if(m.length - j > validSequence -1){
                    equalLetterFoundHorizontal =0;
                    boolean horizontalResult = compareHorizontal(m, letter,i,j);
                    if(horizontalResult){
                        totalSequenceFound++;

                    }
                }

            }
        }
        return totalSequenceFound;
    }

    private boolean compareHorizontal(char[][] m, char letra, int i, int j) {
        if(letra == m[i][j+1]){
            equalLetterFoundHorizontal++;
            if(equalLetterFoundHorizontal == validSequence -1){
                return true;
            }else{
                return compareHorizontal(m,letra,i,j+1);
            }

        }
        return false;
    }
}
