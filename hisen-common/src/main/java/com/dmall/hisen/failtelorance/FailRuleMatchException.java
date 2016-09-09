/**
 * 
 */
package com.dmall.hisen.failtelorance;

public class FailRuleMatchException extends Exception {
    private static final long serialVersionUID = -2797118429524510175L;

    public FailRuleMatchException(String message, Throwable t) {
        super(message, t);
    }

    public FailRuleMatchException(String message) {
        super(message);
    }

}
