package com.dmall.hisen.failtelorance;

/**
 * Description:失效策略工厂类
 * Author:HisenSong
 * DateTime: 2016/9/8 20:46
 */

public class FailureToleranceFactory {

    public static  FailureTolerance getFailureTolenrance(FailureToleranceStrategyEnum strategy) {
        if (strategy == FailureToleranceStrategyEnum.FAIL_FAST) {
            return new FailfastTolerance();
        } else if (strategy == FailureToleranceStrategyEnum.FAIL_OVER) {
            return new FailoverTolerance();
        } else if (strategy == FailureToleranceStrategyEnum.FAIL_SAFE) {
            return new FailsafeTolerance();
        }
        return null;
    }
}
