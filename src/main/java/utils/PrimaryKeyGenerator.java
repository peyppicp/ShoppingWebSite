package utils;

import java.util.UUID;

/**
 * Created by peyppicp on 2017/3/9.
 */
public class PrimaryKeyGenerator {

    /**
     * Generate a uuid String with "-".Length:36
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generate a uuid String without "-".Length:32
     *
     * @return
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
