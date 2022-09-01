package com.my.shiroRealmDemo2.service;

/**
 * 模拟用户数据查询
 * @author Gzy
 * @version 1.0
 */
public interface ShiroManagerService2 {

    /**
     * 通过用户名查询用户密码
     * @param userName
     * @return password
     */
    String getPasswordByUserName(String userName);

}
