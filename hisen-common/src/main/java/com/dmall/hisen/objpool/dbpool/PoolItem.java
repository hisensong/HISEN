package com.dmall.hisen.objpool.dbpool;

/**
 * Description:池子中放的东西(具有状态以及用户实际需要的东西，实际上就是个包装类)
 *
 *              实现类的包装对象(添加状态)：
 * Author:HisenSong
 * DateTime: 2016/9/28 11:52
 */

public class PoolItem {

    public boolean isUse;
    public IConnection conn;

    public PoolItem(IConnection conn){
        this.conn = conn;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public IConnection getConn() {
        return conn;
    }

    public void setConn(IConnection conn) {
        this.conn = conn;
    }
}
