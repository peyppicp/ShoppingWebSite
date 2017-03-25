package utils;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.hash.Hashing;
import common.constants.TokenConstants;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by peyppicp on 2017/3/21.
 */
public class TokenGenerator {

    public static String token() {
        return UUID.randomUUID().toString();
    }
}
