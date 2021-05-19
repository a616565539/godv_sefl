package com.godv.lgd.redis;


import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @param
 */
@Component
public class RedisCacheAuto {


    /**
     * Redis锁键
     */
    public static final String REDIS_LOCK_KEY = "redis_lock";

    /**
     * Redis过期时间   10s
     */
    public static final Long REDIS_EXPIRE_TIME = 10L;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 获取包含指定字符key的集合
     *
     * @param pattern
     * @return
     */
    public Set<Object> getKeysByPattern(String pattern) {
        try {
            Set<Object> keys = redisTemplate.keys(pattern);
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Object> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }


    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey + "", value);
    }

    /**
     * 哈希 批量添加
     *
     * @param key
     * @param map
     */
    public void hmSetAll(String key, Map<String, Object> map) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        hash.putAll(key, map);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(Object key, Object hashKey) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key + "", hashKey + "");
    }

    /**
     * 哈希获取所有数据
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmGetAll(String key) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }


    /**
     * 哈希判断存在的key
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hmHasKey(String key, Object hashKey) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.hasKey(key, hashKey);
    }

    /**
     * 判断没过期的缓存是否存在
     */
    public boolean expire(final String key) {
        boolean result = true;
        try {
            Long expire = redisTemplate.getExpire(key);
            if (expire != null && expire < 0) {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 哈希判断存在的key
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Long hmRmKey(String key, Object... hashKey) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.delete(key, hashKey);
    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    public void lPush(String k, Object v) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 列表获取One
     *
     * @param k
     * @return
     */
    public Object leftPopToList(String k) {
        return redisTemplate.opsForList().leftPop(k);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key) {
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }


    /**
     * 获取已存在缓存value自增值
     *
     * @param key
     * @return
     */
    public long incr(String key) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return counter.incrementAndGet();
    }

    /**
     * 获取未存在缓存value自增值
     *
     * @param key
     * @param increment
     * @return
     */
    public long setnx(String key, int increment) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return counter.addAndGet(increment);
    }

    /**
     * 释放锁
     */
    public void unlock() {
        if (exists(REDIS_LOCK_KEY)) {
            remove(REDIS_LOCK_KEY);
        }
    }

    public void unlock(String key) {
        if (exists(key)) {
            remove(key);
        }
    }

    /**
     * 获取分布式锁
     *
     * @return
     */
    public boolean lock() {
        String lockKey = REDIS_LOCK_KEY;
        long timeout = REDIS_EXPIRE_TIME;
        boolean result = false;
        try {
            long value = System.currentTimeMillis() + timeout;
            ValueOperations operations = redisTemplate.opsForValue();
            result = operations.setIfAbsent(lockKey, String.valueOf(value));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 设置过期时间
            redisTemplate.expire(lockKey, timeout, TimeUnit.SECONDS);
        }
        return result;
    }

    public boolean lock(String lockKey) {
        long timeout = REDIS_EXPIRE_TIME;
        boolean result = false;
        try {
            long value = System.currentTimeMillis() + timeout;
            ValueOperations operations = redisTemplate.opsForValue();
            result = operations.setIfAbsent(lockKey, String.valueOf(value));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 设置过期时间
            redisTemplate.expire(lockKey, timeout, TimeUnit.SECONDS);
        }
        return result;
    }

}
