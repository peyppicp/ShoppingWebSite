package utils;

import com.google.common.base.Charsets;
import common.constants.TokenConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by peyppicp on 2017/3/27.
 */
public class TestUtils {

    @Test
    public void test2() {
        String str = "eyJ1c2VyX2lkIjoiNjg1NWZiNjYtN2UzOC00MGIzLTgyNTEtNmU0MDZjZjhiOTMyIiwidXNlcl9uYW1lIjoi5LmM5YWwIiwiZXhwIjoxNDkxMjQzNzE2NTY5LCJpYXQiOjE0OTA2Mzg5MTY1Njl9";
        System.out.println(new String(Base64.decodeBase64(str), Charsets.UTF_8));
    }

    @Test
    public void test1() {
        String str = "eyJ1c2VyX2lkIjoiNmJkZjk5ZTEtODZjMS00ZmIzLTkwODktMGY2NWIxYWMyYmIyIiwidXNlcl9uYW1lIjoiztrAvCIsImV4cCI6MTQ5MTI0MjE3NjU0NywiaWF0IjoxNDkwNjM3Mzc2NTQ3fQ==";
        byte[] bytes = Base64.decodeBase64(str);
        System.out.println(str);
        System.out.println(new String(bytes, Charsets.UTF_8));

        JSONObject payload = new JSONObject();
        payload.put("iat", 1490637376547L);
        payload.put("exp", 1491242176547L);
        payload.put("user_id", "6bdf99e1-86c1-4fb3-9089-0f65b1ac2bb2");
        payload.put("user_name", "乌兰");
        String token = Base64.encodeBase64String(payload.toString().getBytes(Charsets.UTF_8));
        System.out.println(token);
        System.out.println(new String(Base64.decodeBase64(token), Charsets.UTF_8));
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        JSONObject header = new JSONObject();
        JSONObject payload = new JSONObject();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        long currentTimeMillis = System.currentTimeMillis();
        payload.put("iat", 1490637376547L);
        payload.put("exp", 1491242176547L);
        payload.put("user_id", "6bdf99e1-86c1-4fb3-9089-0f65b1ac2bb2");
        payload.put("user_name", "乌兰");
        String header_payload_base64 = Base64.encodeBase64String(header.toString().getBytes()) + "." +
                Base64.encodeBase64String(payload.toString().getBytes());
        System.out.println(header_payload_base64);
        String signature = HmacUtils.hmacSha256Hex(TokenConstants.SEED, header_payload_base64);
        header_payload_base64 = header_payload_base64 + "." + signature;
        System.out.println(header_payload_base64);
    }
}
