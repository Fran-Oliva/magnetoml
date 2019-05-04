package Util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.ResponseTransformer;

/**
 *
 * @author foliva
 */
public class JsonUtil {

    public static <T extends Object> T fromJson(String json, Class<T> clase) {
        return new Gson().fromJson(json, clase);
    }
    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
    private static String toJson(Object object) {
        if(object == null){
            return "";
        }

        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(object.toString()).getAsJsonObject();

        return json.toString();
    }
}
