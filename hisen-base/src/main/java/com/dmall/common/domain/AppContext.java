//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.domain;

import java.io.Serializable;

public class AppContext implements Serializable {
    private static final long serialVersionUID = -6841769478216085204L;
    private String sysSource;
    private String version;
    private String token;

    public AppContext() {
    }

    public String getSysSource() {
        return this.sysSource;
    }

    public void setSysSource(String sysSource) {
        this.sysSource = sysSource;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
