package com.dmall.hisen.service.impl;

import com.dmall.hisen.domain.User;
import com.dmall.hisen.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/12 10:56
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public User findOne(User user) {
        user.setAge(18);
        user.setSex("男");
        return user;
    }

    @Override
    public int update(User user) {
        return 1;
    }
}
