package cache;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import utils.PrimaryKeyGenerator;

import java.util.concurrent.TimeUnit;

/**
 * Created by peyppicp on 2017/3/22.
 */
public class TestCache {

    @Test
    public void test() {
        EasyCache instance = EasyCache.getInstance();
        String str1 = PrimaryKeyGenerator.uuid();
        String str2 = PrimaryKeyGenerator.uuid();
        Stopwatch started = Stopwatch.createStarted();
        instance.setValue(str1, "peyppicp");
        instance.setValue(str2, "wulan");
        for (int i = 0; i < 10000; i++) {
            instance.setValue(PrimaryKeyGenerator.uuid(), PrimaryKeyGenerator.uuid());
        }
        System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(instance.getValue(str1));
        System.out.println(instance.getValue(str2));
    }
}
