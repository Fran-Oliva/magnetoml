/**
 *
 * @author foliva
 */
import static spark.Spark.*;
public class MagnetoApi {

    public MagnetoApi(){
        port(getHerokuAssignedPort());
        System.out.println("Creando API Magneto");
        System.out.println("Port "+getHerokuAssignedPort());
        get("/hello", (req, res) -> "Hello World");

    }


    public static void main(String[] args) {
        MagnetoApi magnetoApi = new MagnetoApi();
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
