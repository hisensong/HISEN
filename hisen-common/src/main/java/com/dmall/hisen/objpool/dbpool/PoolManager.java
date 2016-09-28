package com.dmall.hisen.objpool.dbpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:池子管理类
 * Author:HisenSong
 * DateTime: 2016/9/28 14:12
 */

public class PoolManager {

    private List<PoolItem> items = new ArrayList<>();

    /**
     * 往池子里面放东西
     * @param connection
     */
    public synchronized void add(IConnection connection){
        items.add(new PoolItem(connection));
    }

    /**
     * 从池子中获取对象
     * @return
     * @throws PoolEmptyException
     */
    public synchronized IConnection get() throws PoolEmptyException{
        int len = items.size();
        for(int i = 0; i< len;i++){
            PoolItem item = items.get(i);
            //如果该item空闲则返回该item,否则获取下一个item
            if(item.isUse() == false){
                item.setUse(true);
                return item.conn;
            }
        }
        throw new PoolEmptyException();
    }

    /**
     * 释放对象
     * @param connection
     */
    public synchronized void release(IConnection connection) throws PoolEmptyException {
        int len = items.size();
        for(int i = 0 ; i< len ; i++){
            PoolItem item = items.get(i);
            if(item.getConn().equals(connection)){
                item.setUse(false);
                return;
            }
        }

        throw new PoolEmptyException();
    }


}
