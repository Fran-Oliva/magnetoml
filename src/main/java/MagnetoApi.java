/**
 *
 * @author foliva
 */
import Mongo.MongoDriver;
import RestServices.MutantRestService;

import static spark.Spark.*;
public class MagnetoApi {

    public MagnetoApi(){

        port(getHerokuAssignedPort());
    }
    private void loadRestService(){
        new MutantRestService();
        Exceptions.getInstance().create();
    }


    public static void main(String[] args) {
        MagnetoApi magnetoApi = new MagnetoApi();
        magnetoApi.loadRestService();
        magnetoApi.loadDB();
    }

    private void loadDB() {
        MongoDriver.getInstance().initialize();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
