package utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/3/9.
 */
public class PrimaryKeyGeneratorTest {
    @Test
    public void uuid() throws Exception {
        String uuid = PrimaryKeyGenerator.uuid();
        System.out.println(uuid);
        System.out.println(uuid.length());
    }

    @Test
    public void uuid2() throws Exception {
        String uuid = PrimaryKeyGenerator.uuid2();
        System.out.println(uuid);
        System.out.println(uuid.length());
    }

}