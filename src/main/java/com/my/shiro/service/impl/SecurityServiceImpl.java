package com.my.shiro.service.impl;

import com.my.shiro.service.SecurityService;

/**
 * @author Gzy
 * @version 1.0
 */
public class SecurityServiceImpl implements SecurityService {

    /**
     * 模拟通过用户名获取密码
     * @param loginName
     * @return
     */
    @Override
    public String findPasswordByLoginName(String loginName) {
        return "123";
    }
}
