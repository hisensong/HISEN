package com.dmall.hisen.failtelorance;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description:fail safe 策略实现
 * Author:HisenSong
 * DateTime: 2016/9/8 20:41
 */

public class FailsafeTolerance extends AbstractFailTolerance {

    private static Log logger = LogFactory.getLog(FailsafeTolerance.class);

    @Override
    public <S, T> T invoke(S object, String methodName, Object... parameters) {
        try{
            return invokeMethod(object, methodName, parameters);
        }catch (Exception e){
            logger.error("failsafe tolerance, exception ignored", e);
            /** ignore the invoke exception */
        }
        return null;
    }
}
