package Business;

import Business.Searches.Horizontal;
import Business.Searches.Oblique;
import Business.Searches.Vertical;
import Exceptions.ForbiddenException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.List;

public class VerifyMutantBusiness {
    List<String> basesNitrogenadas = new ArrayList<>();
    public VerifyMutantBusiness(){
        basesNitrogenadas.add("A");
        basesNitrogenadas.add("T");
        basesNitrogenadas.add("C");
        basesNitrogenadas.add("G");
    }

    public Object verify(JsonObject body) throws ForbiddenException {
        JsonElement dna = body.get("dna");
        JsonArray dnaArray = dna.getAsJsonArray();
        char[][] matrixChar= new char[dnaArray.size()][dnaArray.size()];
        for (int i = 0; i < dnaArray.size(); i++) {
            JsonElement element = dnaArray.get(i);
            String word = element.getAsString();
            for (int j = 0; j < word.length(); j++) {
                if(basesNitrogenadas.contains(String.valueOf(word.charAt(j)))){
                    matrixChar[i][j]=word.charAt(j);
                }else{
                   throw new ForbiddenException(403,"Not a letter (A,T,C,G)");
                }
            }
        }

        Oblique oblique = new Oblique();
        int totalOblique = oblique.obliqueSearch(matrixChar);
        Horizontal horizontal = new Horizontal();
        int totalHorizontal = horizontal.horizontalSearch(matrixChar);
        Vertical vertical = new Vertical();
        int totalVertical = vertical.verticalSearch(matrixChar);
        int total = totalHorizontal + totalOblique + totalVertical;
        JsonObject response = new JsonObject();
        JsonElement element = new JsonPrimitive("200-ok");
        if(total>1){
            response.add("status", element);
            return response;
        }else{
            throw new ForbiddenException();
        }
    }
}
