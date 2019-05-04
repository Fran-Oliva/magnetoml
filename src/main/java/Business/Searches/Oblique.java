package Business.Searches;

public class Oblique {
    private int validSequence = 4;
    private int equalLetterFoundRigth = 0;
    private int equalLetterFoundLeft = 0;

    public int obliqueSearch(char[][] m){
        String root="";
        char letter;
        int sequenceFoundRigth = 0;
        int sequenceFoundLeft = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                root = i+","+j;
                letter = m[i][j];
                if(m.length - i > validSequence -1 && m.length -j > validSequence -1){
                    equalLetterFoundRigth = 0;
                    boolean resultRigth = compareToRigth(m,letter,i,j);
                    if(resultRigth) {
                        sequenceFoundRigth++;
                    }
                }
                if(m.length- validSequence -1  > i && m.length > j && j > validSequence -2){
                    equalLetterFoundLeft = 0;
                    boolean resultLeft = copareToLeft(m,letter,i,j);
                    if(resultLeft) {
                        sequenceFoundLeft++;
                    }
                }

            }

        }
        int totalFound = sequenceFoundRigth + sequenceFoundLeft;
        return totalFound;
    }


    private boolean copareToLeft(char[][] m, char letra, int i, int j) {
        if (letra == m[i+1][j-1]) {
            equalLetterFoundLeft++;
            if(equalLetterFoundLeft == validSequence -1){
                return true;
            }else{
                return copareToLeft(m,letra,i+1,j-1);
            }
        }
        return false;
    }

    private boolean compareToRigth(char[][] m, char letra, int i, int j) {
        if (letra == m[i+1][j+1]) {
            equalLetterFoundRigth++;
            if(equalLetterFoundRigth == validSequence -1){
                return true;
            }else{
                return compareToRigth(m,letra,i+1,j+1);
            }
        }
        return false;
    }

}
