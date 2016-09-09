package com.dmall.hisen.failtelorance;

/**
 * File: NullFailRule.java
 * Description: 空失效规则，永远不会匹配
 * Company: 国美小额贷款有限公司
 * Author: guicl
 * Datetime: 2016-05-19 16:33
 */
public class NullFailRule implements FailRule {
    @Override
    public <S> boolean match(S source) {
        return false;
    }

    @Override
    public String getFailMessage() {
        return "this is a useless fail rule";
    }
}
