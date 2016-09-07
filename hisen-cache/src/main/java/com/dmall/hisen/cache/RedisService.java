package com.dmall.hisen.cache;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/2 15:43
 */

public interface RedisService {

     void set(String key, String val);

     void setex(String key, String val,int minutes);

     void setexRandom(String key, String val,int minutes);

     void setObj(String key, Object val);

     void setObjex(String key, Object val,int minutes);

     void setObjexRandom(String key, Object val,int minutes);

     String getString(String key);

     int getInt(String key);

     <T> T getObj(String key, Class<T> clazz);

     <T> List<T> getList(String key, Class<T> clazz);

     Long del(String... key);

     Long incr(String key);

     Long decr(String key);

     void lpush(String key,String... val);

     String rpop(String key);

     long  expire(String key, int seconds);

     long pipelined(List<Map<String,String>> list);
}
