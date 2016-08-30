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

    //发送奖品队列-优惠券 1 优惠券 2 礼品 3 无奖品
    public static String PRIZE_LIST(int prizeType){
        return "PRIZE_COUPON_LIST:TYPE"+prizeType;
    }

    public static String WINNER_LIST(Long actId) {
        return "WINNER_LIST:"+actId;
    }

    //定时任务随机
    public static String TASK_RANDOM(int taskId){
        return "TASK_RANDOM:"+taskId;
    }

    public static String ACT_INFO(Long actId){
        return "ACT_INFO:"+actId;
    }

    public static String ACT_ITEM_INFO(Long itemId){
        return "ACT_ITEM_INFO:"+itemId;
    }

    //项目当前运行场次
    public static String ACT_ITEM_TIMES_INFO(Long itemId){
        return "ACT_ITEM_TIMES_INFO:"+itemId;
    }

    public static String ACT_NOTICE(Long actId){
        return "ACT_NOTICE:"+actId;
    }

    public static String ACT_ITEMLIST(Long actId){
        return "ACT_ITEMLIST:"+actId;
    }

    public static String ACT_ITEM_LIST_BYCODE(String code){
        return "ACT_ITEM_LIST_BYCODE:"+code;
    }

    //用户参加活动次数 总共
    public static String ACT_USER_COUNT(Long actId,String phone,Long userId){
        return "ACT_USER_COUNT:"+"ACT_"+actId+"USERPHONE_"+phone+"USERID_"+userId;
    }
    //用户参加活动次数 每天 总共
    public static String ACT_USER_COUNT_BYDAY(Long actId,String phone,Long userId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "ACT_USER_COUNT_BYDAY:"+"ACT_"+actId+"USERPHONE_"+phone+"USERID_"+userId+"DAY_"+ sdf.format(new Date());
    }

    //用户参加项目次数 总共
    public static String ACT_ITEM_USER_COUNT(String itemCode,String phone,Long userId){
        return "ACT_ITEM_USER_COUNT:"+"ITEMCODE_"+itemCode+"USERPHONE_"+phone+"USERID_"+userId;
    }
    //用户参加项目次数 每天 总共
    public static String ACT_ITEM_USER_COUNT_BYDAY(String itemCode,String phone,Long userId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "ACT_ITEM_USER_COUNT_BYDAY:"+"ITEMCODE_"+itemCode+"USERPHONE_"+phone+"USERID_"+userId+"DAY_"+ sdf.format(new Date());
    }

    //用户信息 通过手机
    public static String ACT_USER_INFO_BYPHONE(String phone){
        return "ACT_USER_INFO_BYPHONE:"+phone;
    }

    //用户信息 通过id
    public static String ACT_USER_INFO_BYID(String id){
        return "ACT_USER_INFO_BYID:"+id;
    }

    //用户信息 通过loginid
    public static String ACT_USER_INFO_BYLOGIN(String loginId){
        return "ACT_USER_INFO_BYLOGIN:"+loginId;
    }

    //库存信息
    public static String ACT_ITEM_TIMES_STOCK(Long timesId){
        return "ACT_ITEM_TIMES_STOCK:"+timesId;
    }

    //用户黑名单
    public static String ACT_BLACK_USER(String phone){
        return "ACT_BLACK_USER:"+phone;
    }

    //活动场次列表
    public static String ACT_TIMES_LIST(Long actId) {
        return "ACT_TIMES_LIST:"+actId;
    }

    //定时任务开关redis
    public static String TASK_SWITCH(){
        return "TASK_SWITCH";
    }

}
