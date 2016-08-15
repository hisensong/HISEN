//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.domain;

import java.io.Serializable;

public class KeyValue<T, M> implements Serializable {
    private T key;
    private M value;

    public KeyValue(T key, M value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public M getValue() {
        return this.value;
    }

    public void setValue(M value) {
        this.value = value;
    }
}
