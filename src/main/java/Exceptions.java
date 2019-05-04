import static spark.Spark.exception;
import Exceptions.*;

public class Exceptions {
    private static final Exceptions INSTANCE = new Exceptions();

    private Exceptions() {

    }

    public static Exceptions getInstance() {
        return INSTANCE;
    }

    public void create() {
        exception(ForbiddenException.class, (exception, request, response) -> {
            response.status(ForbiddenException.CODE);
            response.body("{\"code\": " + exception.getCode() + ",\"message\":\""+ exception.getMessage() + "\"}");
        });
    }
}
