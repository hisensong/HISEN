package com.dmall.hisen.cache.impl;


import com.alibaba.fastjson.JSON;
import com.dmall.hisen.cache.RedisService;
import com.dmall.hisen.cache.client.RedisClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

/**
 * Description:Redis 操作 service.
 *
 * @author hisensong
 * @version V1.0
 * @since 15-11-24
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    private Log logger = LogFactory.getLog(RedisServiceImpl.class);

    @Autowired
    private RedisClient redisClient;
    private int defaultExpireTime = 1440;//=24小时=一天
    private static final boolean USE_REDIS = true;//redis全局开关 主要影响 get 方法

    @Override
    public void set(String key, String val) {
        redisClient.setex(key,val,defaultExpireTime*60);
    }

    @Override
    public void setex(String key, String val, int minutes) {
        redisClient.setex(key,val,minutes*60);
    }

    @Override
    public void setexRandom(String key, String val, int minutes) {
        Random r = new Random();
        minutes = r.nextInt(minutes-1)+1;
        setex(key,val,minutes);
    }

    @Override
    public void setObj(String key, Object val) {
        set(key, JSON.toJSONString(val));
    }

    @Override
    public void setObjex(String key, Object val, int minutes) {
        setex(key,JSON.toJSONString(val),minutes);
    }

    @Override
    public void setObjexRandom(String key, Object val, int minutes) {
        setexRandom(key,JSON.toJSONString(val),minutes);
    }

    @Override
    public String getString(String key) {
        if(!USE_REDIS){
            return null;
        }
       return redisClient.get(key);
    }

    @Override
    public int getInt(String key) {
        String val = getString(key);
        int res = 0 ;
        if(!StringUtils.isEmpty(val)){
            res = Integer.parseInt(val);
        }
        return res;
    }

    @Override
    public <T> T getObj(String key, Class<T> clazz) {
        String val = getString(key);
        return JSON.parseObject(val,clazz);
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        try {
            String val = getString(key);
            if(StringUtils.isEmpty(val)){
                return null;
            }
            return JSON.parseArray(val,clazz);
        }catch (Exception e){
            logger.error("getList error:,e");
            return null;
        }
    }

    @Override
    public Long del(String... key) {
        return redisClient.del(key);
    }

    @Override
    public Long incr(String key) {
        return redisClient.incrBy(key,0);
    }

    @Override
    public Long decr(String key) {
        return redisClient.decrBy(key,0);
    }

    @Override
    public void lpush(String key, String... val) {
        redisClient.lpush(key,val);
    }

    @Override
    public String rpop(String key) {
        return redisClient.rpop(key);
    }
}
