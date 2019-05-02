package RestServices;

import Exceptions.ForbiddenException;
import Util.JsonUtil;
import spark.Request;

public class GeneralRestService {
    /**
     * Obtiene el body de una petición y lo parsea a un objeto
     * @author foliva
     * @param request Petición
     * @param clase Objeto
     * @param <T>
     * @return Body de la petición
     */
    protected <T extends Object> T getRequestBody(Request request, Class<T> clase) {

        T body;
        try{
            body = JsonUtil.fromJson(request.body(), clase);
        } catch (Exception e) {
            throw new ForbiddenException(10029, "Cuerpo de la petición malformado");
        }

        if(body == null)
            throw new ForbiddenException(10028, "Se espera contenido en el body de la petición");

        return body;
    }

}
