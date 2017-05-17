package com.dmall.hisen.stragy;

/**
 * Description:策略模式上下文
 * Author:HisenSong
 * DateTime: 2017/5/17 10:58
 */

public class StrategeContext {

    private Stratege stratege;

    public StrategeContext() {
    }

    public StrategeContext(Stratege stratege) {
        this.stratege = stratege;
    }

    public Stratege getStratege() {
        return stratege;
    }

    public void setStratege(Stratege stratege) {
        this.stratege = stratege;
    }

    public void invoke(){
        System.out.println("调用开始=================");
        stratege.handle();
        System.out.println("调用结束=================");
    }
}
