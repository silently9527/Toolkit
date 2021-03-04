package cn.silently9527.service;


public interface CacheService {
    void put(String key, Object vlaue);

    Object get(String key);
}
