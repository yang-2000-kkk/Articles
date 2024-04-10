package com.zfcgdbinterface.cache;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * guava 缓存
 * @author zht
 * @date 2019/7/27 11:13
 **/
@Component
@Slf4j
public class LoadingLocalCache {

    private static LoadingCache<String, Object> loadingCache;

    private static LoadingLocalCache loadingLocalCache;

    private static int DEFAULT_CONCURRENCY_LEVEL= 4;

    private static int DEFAULT_EXPIRE= 20;

    private static int DEFAULT_INITIAL_CAPACITY= 16;

    private static int DEFAULT_MAXIMUM_SIZE= 100;

    private static TimeUnit DEFAULT_TIME_UNIT= TimeUnit.SECONDS;

    static {
        init();
    }

    private LoadingLocalCache(){}

    private static void init() {
        loadingCache= CacheBuilder
                .newBuilder()
                //并发级别（同时写入缓存的线程数）
                .concurrencyLevel(DEFAULT_CONCURRENCY_LEVEL)
                //过期时间
                .expireAfterWrite(DEFAULT_EXPIRE,DEFAULT_TIME_UNIT)
                //初始容量
                .initialCapacity(DEFAULT_INITIAL_CAPACITY)
                //最大容量,超过之后默认按照LRU算法最近使用最少移除缓存项
                .maximumSize(DEFAULT_MAXIMUM_SIZE)
                //设置统计缓存的命中率
                .recordStats()
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        log.info(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(
                        new CacheLoader<String, Object>() {
                            @Override
                            public Object load(String key) throws Exception {
                                return -1;
                            }
                        }
                );
    }

    public static Object put(String key, Object value){
        loadingCache.put(key, value);
        return value;
    }

    public static Object get(String key) throws Exception {
        return loadingCache.get(key);
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
