package Util;

import com.google.gson.Gson;

/**
 *
 * @author foliva
 */
public class JsonUtil {

    public static <T extends Object> T fromJson(String json, Class<T> clase) {
        return new Gson().fromJson(json, clase);
    }
}
