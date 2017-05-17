package com.dmall.hisen.stragy;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2017/5/17 11:13
 */

public class StrategeTest {

    public static void main(String[] args){
        Stratege  stratege =  StrategeFactory.getStrategeByCode(StrateEnum.STRATEGE_A);
        StrategeContext strategeContext = new StrategeContext(stratege);
        strategeContext.invoke();

    }
}
