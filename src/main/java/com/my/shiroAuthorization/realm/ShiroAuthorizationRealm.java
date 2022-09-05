package com.my.shiroAuthorization.realm;

import com.my.shiroAuthorization.service.SecurityService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.Factory;

import java.util.Map;

public class ShiroAuthorizationRealm extends AuthorizingRealm{

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
        //获取当前登录用户
        String principal = String.valueOf(authenticationToken.getPrincipal());

        //通过当前登录用户获取密码和salt(查询数据库)
        SecurityService securityService = new SecurityService();
        Map<String, String> passwordAndSalt = securityService.getPasswordByUserName(principal);

        //创建登录用户信息类
        //TODO


        return null;
    }
}
