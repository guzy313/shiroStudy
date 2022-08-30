package com.my.shiro.realm;

import com.my.shiro.service.impl.SecurityServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

/**
 * @Description custom realm demo
 * @author Gzy
 * @version 1.0
 */
public class CustomRealm extends AuthorizingRealm {

    /**
     * 鉴权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录名
        String principal = String.valueOf(authenticationToken.getPrincipal());

        //模拟从数据库获取密码
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(principal);
        if(!StringUtils.hasLength(password)){
            throw new UnknownAccountException("账户不存在");
        }

        //下方参数getName() 为获取 当前类 CustomRealm 的类名
        return new SimpleAuthenticationInfo(principal,password,getName());
    }
}
