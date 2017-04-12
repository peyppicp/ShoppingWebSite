package utils;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/**
 * Created by peyppicp on 2017/4/12.
 */
public class TokenUtils {

    public static String getUserIdFromToken(String token) {
        String tempJson = token.split("\\.")[1];
        String json = new String(Base64.decodeBase64(tempJson));
        JSONObject jsonObject = new JSONObject(json);
        return (String) jsonObject.get("user_id");
    }
}
