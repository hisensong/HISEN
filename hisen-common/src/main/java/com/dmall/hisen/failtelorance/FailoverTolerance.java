package com.dmall.hisen.failtelorance;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description:fail over 策略实现
 * Author:HisenSong
 * DateTime: 2016/9/8 20:35
 */

public class FailoverTolerance extends AbstractFailTolerance{
    private static Log logger = LogFactory.getLog(FailoverTolerance.class);

    public FailoverTolerance() {
        /* set default retry times  */
        super.setRetryTimes(2);
    }

    @Override
    public <S, T> T invoke(S object, String methodName, Object... parameters) {
        int retries = super.retryTimes;
        for(int i = 1;i <= retries;i++ ){
            try {
                return invokeMethod(object, methodName, parameters);
            }catch (Exception ex){
                logger.error(" invoke failed for the " + i + " times," + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public void setRetryTimes(int retryTimes) {
        super.setRetryTimes(retryTimes);
    }

}
