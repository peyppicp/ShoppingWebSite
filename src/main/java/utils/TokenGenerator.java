package utils;

import com.google.common.base.Charsets;
import common.constants.TokenConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.json.JSONObject;

/**
 * Created by peyppicp on 2017/3/21.
 */
public class TokenGenerator {

    public static String token(String userName, String userPassword, String user_id) {
        JSONObject header = new JSONObject();
        JSONObject payload = new JSONObject();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        long currentTimeMillis = System.currentTimeMillis();
        payload.put("iat", currentTimeMillis);
        payload.put("exp", currentTimeMillis + TokenConstants.time);
        payload.put("user_id", user_id);
        payload.put("user_name", userName);
        String header_payload_base64 = Base64.encodeBase64String(header.toString().getBytes(Charsets.UTF_8)) + "." +
                Base64.encodeBase64String(payload.toString().getBytes(Charsets.UTF_8));
        String signature = HmacUtils.hmacSha256Hex(TokenConstants.SEED, header_payload_base64);
        header_payload_base64 = header_payload_base64 + "." + signature;
        return header_payload_base64;
    }
}
