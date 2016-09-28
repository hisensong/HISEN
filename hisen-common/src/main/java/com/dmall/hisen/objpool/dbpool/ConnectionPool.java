package com.dmall.hisen.objpool.dbpool;

/**
 * Description:数据库连接池
 * Author:HisenSong
 * DateTime: 2016/9/28 14:49
 */

public class ConnectionPool {

    private static PoolManager manager = new PoolManager();

    /**
     *
     * @param count
     */
    public void add(int count){
        for(int i=0;i<count;i++){
            manager.add(new Connection());
        }
    }

    /**
     * 获取连接对象
     * @return
     * @throws PoolEmptyException
     */
    public static IConnection getConnection() throws PoolEmptyException {
        return manager.get();
    }

    /**
     * 释放连接
     * @param connection
     * @throws PoolEmptyException
     */
    public static void release(Connection connection) throws PoolEmptyException {
        manager.release(connection);
    }

}
