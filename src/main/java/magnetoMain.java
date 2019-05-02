/**
 *
 * @author foliva
 */
import static spark.Spark.*;
public class magnetoMain {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
