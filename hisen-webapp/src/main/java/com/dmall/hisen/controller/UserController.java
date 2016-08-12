package com.dmall.hisen.controller;

import com.dmall.hisen.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/12 10:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value="/query", method= RequestMethod.GET)
    public String queryUser(){
        System.out.println("查询用户信息");
        return "query user";
    }


    @ResponseBody
    @RequestMapping(value="/update", method= RequestMethod.GET)
    public User updateUser(){
        System.out.println("查询用户信息");
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setSex("男");
        return user;
    }

}
