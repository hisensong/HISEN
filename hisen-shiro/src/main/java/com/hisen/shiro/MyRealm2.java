package com.hisen.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/10/10 16:11
 */

public class MyRealm2 implements Realm{
    @Override
    public String getName() {
        return "myrealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();//  获取用户名
        String password = new String((char[]) authenticationToken.getCredentials());//获取密码
        if(!"wang".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();//如果密码错误
        }
        //如果身份认证验证成功，返回一个authenticationInfo 实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
