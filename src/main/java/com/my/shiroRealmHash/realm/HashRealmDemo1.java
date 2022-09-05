package com.my.shiroRealmHash.realm;

import com.my.shiroRealmHash.service.SecurityService;
import com.my.shiroRealmHash.tools.DigestsUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Map;

/**
 * @author Gzy
 * @version 1.0
 */
public class HashRealmDemo1 extends AuthorizingRealm {

    public HashRealmDemo1(){
        //指定密码匹配方式sha1 --密码比较器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        //指定密码迭代次数
        hashedCredentialsMatcher.setHashIterations(DigestsUtil.HashIterations);
        //使用父层方法 匹配方式生效 (关键步骤)
        setCredentialsMatcher(hashedCredentialsMatcher);

    }


    /**
     * 授权—认证之后
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
        //获取登录用户
        String userName= String.valueOf(authenticationToken.getPrincipal());

        //模拟从数据库查询密码进行比对
        SecurityService securityService = new SecurityService();
        //获取字符串和salt
        Map<String, String> passwordByUserName = securityService.getPasswordByUserName(userName);
        if(passwordByUserName.isEmpty()){
            throw new UnknownAccountException("账户不存在");
        }

        String password = String.valueOf(passwordByUserName.get("password"));
        String salt = String.valueOf(passwordByUserName.get("salt"));

        //新建用户信息对象——返回用
        SimpleAuthenticationInfo userInfo
                = new SimpleAuthenticationInfo(userName,password,ByteSource.Util.bytes(salt),this.getName());

        return userInfo;
    }
}
