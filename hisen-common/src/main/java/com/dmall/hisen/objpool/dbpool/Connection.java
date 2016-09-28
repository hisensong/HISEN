package com.dmall.hisen.objpool.dbpool;

/**
 * Description:用户真正需要的东西，比如数据库连接
 * Author:HisenSong
 * DateTime: 2016/9/28 11:49
 */

public class Connection implements IConnection {

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void set(Object obj) {

    }
}
