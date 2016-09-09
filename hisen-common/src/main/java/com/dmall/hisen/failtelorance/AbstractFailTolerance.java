package com.dmall.hisen.failtelorance;

import com.dmall.hisen.utils.ReflectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:失效策略抽象实现类
 * Author:HisenSong
 * DateTime: 2016/9/8 19:48
 */

public abstract class AbstractFailTolerance implements FailureTolerance{

    protected int retryTimes = DEFAULT_RETRY_TIMES;
    protected long timeout = DEFAULT_TIME_OUT;
    protected List<FailRule> failRuleList;

    protected  <S,T> T invokeMethod(S object,String methodName,Object... parameter)throws Exception{
        try{
             T t = null;
             Object v = null;
             if(parameter != null){
                 v = ReflectUtil.invokeMethod(object,methodName,parameter);
             }else{
                 v = ReflectUtil.invokeMethod(object,methodName,null,null);
             }

            //校验返回的值是否匹配 failRules
            if(failRuleList != null && !failRuleList.isEmpty()){
                for(FailRule failRule:failRuleList){
                    if(failRule.match(v)){
                        throw new FailRuleMatchException(failRule.getFailMessage());
                    }
                }

            }

            return v == null ? null : (T)v;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    @Override
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    @Override
    public synchronized void registerFailRule(FailRule failRule){
        synchronized (this){
            if(failRuleList == null){
                failRuleList = new ArrayList<>();
            }
        }
        failRuleList.add(failRule);
    }


}
