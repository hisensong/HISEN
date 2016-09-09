package com.dmall.hisen.failtelorance;

/**
 * Description:失效策略接口
 * Author:HisenSong
 * DateTime: 2016/9/8 18:38
 */

public interface FailureTolerance {

    public static final int DEFAULT_RETRY_TIMES = -1;//默认重试次数
    public static final long DEFAULT_TIME_OUT = -1;//默认超时时间

    <S,T> T invoke(S object,String methodName,Object... parameter);

    /**
     * 设置重试次数
     * @param retryTimes
     */
    void setRetryTimes(int retryTimes);

    /**
     * 设置超时时间
     * @param timeOut
     */
    void setTimeout(long timeOut);

    /**
     * 注册失败策略
     * @param failRule
     */
    void registerFailRule(FailRule failRule);

}
