package Business.Searches;

public class Vertical {
    String root ="";
    char letter ='a';
    int validSequence = 4;
    int equalLetterFoundVertical = 0;
    int totalSequenceFound =0;

    public int verticalSearch(char[][] m){
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {

                root = i + "," + j;
                letter = m[i][j];
                if(m.length - i > validSequence -1){
                    equalLetterFoundVertical =0;
                    boolean verticalResult = campareVertical(m,letter,i,j);
                    if(verticalResult){
                        totalSequenceFound++;
                    }

                }

            }
        }
        return totalSequenceFound;
    }

    private boolean campareVertical(char[][] m, char letra, int i, int j) {
        if(letra == m[i+1][j]){
            equalLetterFoundVertical++;
            if(equalLetterFoundVertical == validSequence -1){
                return true;
            }else{
                return campareVertical(m,letra,i+1,j);
            }
        }
        return false;
    }
}
