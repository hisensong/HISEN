package com.dmall.hisen.failtelorance;

/**
 * File: NullResultFailRule.java
 * Description: 结果为空则失效
 * Company: 国美小额贷款有限公司
 * Author: guicl
 * Datetime: 2016-05-30 09:35
 */
public class NullResultFailRule implements FailRule {
    @Override
    public <S> boolean match(S source) {
        return source == null;
    }

    @Override
    public String getFailMessage() {
        return "the value can not be blank";
    }
}
