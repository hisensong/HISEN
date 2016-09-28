package com.dmall.hisen.objpool.dbpool;

/**
 * Description:用户需要的实际的东西都实现这个接口
 * Author:HisenSong
 * DateTime: 2016/9/28 11:47
 */

public interface IConnection {

    Object get();

    void set(Object obj);
}
