package com.dmall.hisen.failtelorance;

/**
 * Description:该接口用来用户自定义失败策略，用于在failtolerance匹配failure
 * Author:HisenSong
 * DateTime: 2016/9/8 19:43
 */

public interface FailRule {

    /**
     * 校验是否对象匹配
     * @param source
     * @param <S>
     * @return
     */
    <S> boolean match(S source);

    /**
     * 获取失败信息
     * @return
     */
    String getFailMessage();
}
