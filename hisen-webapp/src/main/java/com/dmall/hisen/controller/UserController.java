package com.dmall.hisen.controller;

import com.dmall.hisen.domain.User;
import com.dmall.hisen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="/query", method= RequestMethod.GET)
    public User queryUser(){
        User user = new User();
        user.setName("王五");
        return  userService.findOne(user);
    }

    @ResponseBody
    @RequestMapping(value="/update", method= RequestMethod.GET)
    public User updateUser(){
        User user = new User();
        user.setName("updateUser");
        user.setAge(20);
        user.setSex("男");
        return user;
    }

}
