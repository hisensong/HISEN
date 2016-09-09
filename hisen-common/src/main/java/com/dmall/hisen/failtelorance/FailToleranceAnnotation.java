package com.dmall.hisen.failtelorance;

import java.lang.annotation.*;

/**
 * Description:失效策略注解方式
 * Author:HisenSong
 * DateTime: 2016/9/9 10:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FailToleranceAnnotation {

    /**
     * 失败策略
     * @return
     */
    FailureToleranceStrategyEnum strategy() default FailureToleranceStrategyEnum.FAIL_SAFE;

    /**
     * 重试次数
     * @return
     */
    int retryTimes() default FailureTolerance.DEFAULT_RETRY_TIMES;

    /**
     * 超时时间，单位：秒
     * @return
     */
    long timeout() default FailureTolerance.DEFAULT_TIME_OUT;

    /**
     * 自定义规则，可以添加需要的规则。
     * @return
     */
    Class<? extends FailRule>[] failRules() default {};
}
