package cn.silently9527.service.impl;

import cn.silently9527.service.CacheService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CacheServiceImpl implements CacheService {
    private ConcurrentMap<String, Object> cache = new ConcurrentHashMap<>();

    @Override
    public void put(String key, Object vlaue) {
        cache.put(key, vlaue);
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }
}
