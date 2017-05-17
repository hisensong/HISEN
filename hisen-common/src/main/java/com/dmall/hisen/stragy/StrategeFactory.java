package com.dmall.hisen.stragy;

/*
 * Description:
 * Author:HisenSong
 * DateTime: 2017/5/17 11:00
 */

public class StrategeFactory {

    public static Stratege getStrategeByCode(StrateEnum strateEnum){
        if(StrateEnum.STRATEGE_A.getCode().equals(strateEnum.getCode())){
            return new StrategeA();
        }else if(StrateEnum.STRATEGE_B.getCode().equals(strateEnum.getCode())){
            return new StrategeB();
        }else {
            return null;
        }
    }
}
