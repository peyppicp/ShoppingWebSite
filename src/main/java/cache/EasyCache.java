package cache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by peyppicp on 2017/3/22.
 */
public class EasyCache {

    private ConcurrentHashMap<Object, CacheStatus> container;

    private volatile boolean flag = true;

    private Runnable runnable = null;

    private int survival_time = 120000000; // 120min

    private EasyCache() {
        container = new ConcurrentHashMap<Object, CacheStatus>();
        runnable = new Runnable() {
            public void run() {
                try {
                    while (flag) {
                        Iterator<Map.Entry<Object, CacheStatus>> iterator = container.entrySet().iterator();
                        if (!iterator.hasNext()) {
                            synchronized (this) {
                                this.wait();
                            }
                        }
                        while (iterator.hasNext()) {
                            Map.Entry<Object, CacheStatus> entry = iterator.next();
                            CacheStatus cacheStatus = entry.getValue();
                            if (System.currentTimeMillis() - cacheStatus.getStoredTime() >= survival_time) {
                                iterator.remove();
                            } else {
                                cacheStatus.setLoopTimes(cacheStatus.getLoopTimes() + 1);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public Object getValue(Object key) {
        CacheStatus cacheStatus = container.get(key);
        if (cacheStatus != null) {
            return cacheStatus.getValue();
        }
        return null;
    }

    public void setValue(Object key, Object value) {
        CacheStatus cacheStatus = new CacheStatus();
        cacheStatus.setLoopTimes(0);
        cacheStatus.setStoredTime(System.currentTimeMillis());
        cacheStatus.setValue(value);
        container.put(key, cacheStatus);
        synchronized (this) {
            this.notify();
        }
    }

    private static class EasyCacheHolder {
        private static final EasyCache EASY_CACHE = new EasyCache();
    }

    public static EasyCache getInstance() {
        return EasyCacheHolder.EASY_CACHE;
    }
}
