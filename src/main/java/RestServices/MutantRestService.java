package RestServices;

import Business.VerifyMutantBusiness;
import com.google.gson.JsonObject;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

public class MutantRestService extends GeneralRestService {
    private VerifyMutantBusiness verifyMutant;
    public MutantRestService(){

        path("", () -> {
            get("/hello", (req, res) -> "Hello Magneto");

            get("/stats", (req, res) -> {
                return null;
            });

            post("/mutant", (request, response) -> {
                verifyMutant = new VerifyMutantBusiness();
                JsonObject importationBody = this.getRequestBody(request, JsonObject.class);
                return verifyMutant.verify(importationBody);
            });



        });
    }
}
