package com.my.shiroRealmDemo2.realm;

import com.my.shiroRealmDemo2.service.Impl.ShiroManagerService2Impl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Gzy
 * @version 1.0
 */
public class CustomRealm2 extends AuthorizingRealm {

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取当前用户名
        String userName = String.valueOf(authenticationToken.getPrincipal());
        //通过用户名获取密码（模拟从数据库）
        ShiroManagerService2Impl shiroManagerService2 = new ShiroManagerService2Impl();
        String password = shiroManagerService2.getPasswordByUserName(userName);
        //返回认证用户信息
        return  new SimpleAuthenticationInfo(userName,password,this.getName());
    }
}
