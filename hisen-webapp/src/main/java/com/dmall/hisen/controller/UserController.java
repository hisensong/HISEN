package com.dmall.hisen.controller;

import com.dmall.hisen.cache.RedisService;
import com.dmall.hisen.common.RedisKeyBuild;
import com.dmall.hisen.domain.User;
import com.dmall.hisen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/12 10:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="/query", method= RequestMethod.GET)
    public User queryUser(){
        //test redis pipelined  service
        User user = new User();
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("key1","val1");
        map.put("key2","val2");
        map.put("key3","val3");
        list.add(map);
        return  user;
    }

    @ResponseBody
    @RequestMapping(value="/update", method= RequestMethod.GET)
    public User updateUser(){

        User user = new User();
        user.setName("updateUser");
        user.setAge(20);
        user.setSex("男");

        userService.update(user);
        return user;
    }

    /**
     * 测试aop
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/aop", method= RequestMethod.GET)
    public User aop(){
        User user = new User();
        user.setName("updateUser");
        user.setAge(20);
        user.setSex("男");
        userService.update(user);
        return user;
    }

}
