package com.dmall.hisen.cache.impl;


import com.dmall.hisen.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Description:Redis 操作 service.
 *
 * @author hisensong
 * @version V1.0
 * @since 15-11-24
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private  JedisPool jedisPool;


    @Override
    public void set(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key,val);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }


    }

    @Override
    public void setex(String key, String val, int minutes) {

    }

    @Override
    public void setexRandom(String key, String val, int minutes) {

    }

    @Override
    public void setObj(String key, Object val) {

    }

    @Override
    public void setObjex(String key, Object val, int minutes) {

    }

    @Override
    public void setObjexRandom(String key, Object val, int minutes) {

    }

    @Override
    public String getString(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

    @Override
    public <T> T getObj(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public Long del(String key) {
        return null;
    }

    @Override
    public Long incr(String key) {
        return null;
    }

    @Override
    public Long decr(String key) {
        return null;
    }

    @Override
    public void lpush(String key, String val) {

    }

    @Override
    public String rpop(String key) {
        return null;
    }
}
