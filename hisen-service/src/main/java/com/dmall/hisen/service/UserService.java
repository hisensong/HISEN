package com.dmall.hisen.service;

import com.dmall.hisen.domain.User;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/12 10:56
 */

public interface UserService {

     User findOne(User user);

     int update(User user);
}
