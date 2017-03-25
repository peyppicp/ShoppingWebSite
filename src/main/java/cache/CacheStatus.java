package cache;

import lombok.Data;

/**
 * Created by peyppicp on 2017/3/22.
 */
@Data
public class CacheStatus {

    private long storedTime;

    private int loopTimes;

    private Object value;

}
