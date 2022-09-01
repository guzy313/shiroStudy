package com.my.shiroRealmDemo2.service.Impl;

import com.my.shiroRealmDemo2.service.ShiroManagerService2;

/**
 * @author Gzy
 * @version 1.0
 */
public class ShiroManagerService2Impl implements ShiroManagerService2 {
    @Override
    public String getPasswordByUserName(String userName) {
        return "123";//固定密码
    }
}
