package RestServices;

import Business.MutantBusiness;
import Util.JsonUtil;
import com.google.gson.JsonObject;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

public class MutantRestService extends GeneralRestService {
    private MutantBusiness mutantBusiness;
    public MutantRestService(){

        path("", () -> {
            get("/hello", (req, res) -> "Hello Magneto");

            get("/stats", (req, res) -> {
                mutantBusiness = new MutantBusiness();
                return mutantBusiness.getStats();
            }, JsonUtil.json());

            post("/mutant", (request, response) -> {
                mutantBusiness = new MutantBusiness();
                JsonObject importationBody = this.getRequestBody(request, JsonObject.class);
                return mutantBusiness.verify(importationBody);
            }, JsonUtil.json());



        });
    }
}
