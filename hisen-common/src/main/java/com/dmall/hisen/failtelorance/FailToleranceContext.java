package com.dmall.hisen.failtelorance;

/**
 *
 * Author:HisenSong
 * DateTime: 2016/9/8 20:48
 * Description:
 * 失效调用上下文类，调用示例代码：
 * <pre>
 *     FailureTolerance failover = FailureToleranceFactory.getFailureTolenrance(FailureToleranceStrategyEnum.FAIL_OVER);
 *     Assert.assertNull(FailToleranceContext.getInstance(failover).invoke(pycreditClient, "queryOriginReport", queryInfo));
 * </pre>
 */
public class FailToleranceContext {

    private FailureTolerance ft;

    private FailToleranceContext(){}

    public static FailToleranceContext getInstance(){
        return new FailToleranceContext();
    }

    public static FailToleranceContext getInstance(FailureTolerance ft){
        FailToleranceContext context = new FailToleranceContext();
        context.ft = ft;
        return context;
    }

    public void setFailTolerance(FailureTolerance ft) {
        this.ft = ft;
    }


    public  <S, T> T invoke(S object, String methodName, Object... parameters){
        if (ft == null)
            throw new IllegalStateException("no fail tolerance strategy, please set the strategy first before invoke");
        return ft.invoke(object, methodName, parameters);
    }

}
