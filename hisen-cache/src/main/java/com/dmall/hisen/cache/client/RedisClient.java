package com.dmall.hisen.cache.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/7 10:59
 */

public class RedisClient {
    private Log logger = LogFactory.getLog(RedisClient.class);

    @Autowired
    private JedisPool jedisPool;

    private String auth;

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }

    public void set(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            jedis.set(key,val);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void setex(String key, String val,int second) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            jedis.setex(key,second,val);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String  get(String key) {
        if (key == null)
            return null;
        String value = null;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            value = jedis.get(key);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    public long  del(String... keys) {
        long num = 0;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            num = jedis.del(keys);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return num;
    }

    public long  incrBy(String key,long num) {
        long result = 0;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            result =jedis.incrBy(key,num);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }


    public long  decrBy(String key,long num) {
        long result = 0;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            result =jedis.decrBy(key,num);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public long  lpush(String key,String... vals) {
        long result = 0;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            result =jedis.lpush(key,vals);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public String  rpop(String key) {
        String result = null;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            result =jedis.rpop(key);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public long  expire(String key, int seconds) {
        long result = 0;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth(this.getAuth());
            result =jedis.expire(key,seconds);
        } catch (Exception e) {
            logger.error("redis has an error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

}
