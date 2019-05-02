/**
 *
 * @author foliva
 */
import static spark.Spark.*;
public class MagnetoMain {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
