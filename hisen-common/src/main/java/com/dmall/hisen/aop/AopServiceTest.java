package com.dmall.hisen.aop;

import com.dmall.hisen.failtelorance.FailToleranceAnnotation;
import com.dmall.hisen.failtelorance.FailureToleranceStrategyEnum;
import com.dmall.hisen.failtelorance.NullFailRule;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/9 11:52
 */
@Component
public class AopServiceTest {

    @FailToleranceAnnotation(strategy = FailureToleranceStrategyEnum.FAIL_OVER,retryTimes = 2,timeout = 2,failRules = {NullFailRule.class,NullFailRule.class})
    public void sendPost(){
        System.out.println("测试AOP和注解联合使用.....");
    }
}
