package com.dmall.hisen.aop;

import com.dmall.hisen.failtelorance.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Description:失效注解AOP
 * Author:HisenSong
 * DateTime: 2016/9/9 11:32
 */
@Aspect
@Component
public class FailToleranceAOP {

    @Around("within(com.dmall.hisen..*) && @annotation(fta)")
    public Object around(ProceedingJoinPoint jp, FailToleranceAnnotation fta) throws Throwable{
        FailureToleranceStrategyEnum failureToleranceStrategyEnum =  fta.strategy();
        FailureTolerance ft = FailureToleranceFactory.getFailureTolenrance(failureToleranceStrategyEnum);
        ft.setRetryTimes(fta.retryTimes());
        ft.setTimeout(fta.timeout());
        //添加自定义失效策略
        if(fta.failRules() != null && fta.failRules().length > 0){
            for(Class<? extends FailRule> clz:fta.failRules() ){
                ft.registerFailRule(clz.newInstance());
            }
        }

        Object retVal = FailToleranceContext.getInstance(ft).invoke(jp,"proceed");
        return retVal;
    }


}
