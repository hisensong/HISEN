package com.dmall.hisen.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:Redis key构造器.
 *
 * @author yudong.chang
 * @version V1.0
 * @since 15-11-24
 */
public class RedisKeyBuild {

    private static final String HISEN_CACHE = "HISEN_CACHE";


    public static String STUDENT(int id){
        return HISEN_CACHE + "_STUDENT:" + id;
    }

    public static String USER(int id){
        return HISEN_CACHE + "_USER:" + id;
    }

}
