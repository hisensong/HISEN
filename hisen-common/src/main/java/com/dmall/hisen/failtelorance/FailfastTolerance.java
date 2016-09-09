package com.dmall.hisen.failtelorance;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * File: FailfastTolerance.java
 * Description:
 * Author: :HisenSong
 * Datetime:  2016/9/8 19:43
 */

/**
 * fail fast 策略实现
 */
public class FailfastTolerance extends AbstractFailTolerance  {
    private static Log logger = LogFactory.getLog(FailfastTolerance.class);


    @Override
    public <S, T> T invoke(S object, String methodName, Object... parameter) {
        try{
            return invokeMethod(object,methodName,parameter);
        }catch (Exception e){
            logger.error("failfast tolerance, exception raised", e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
