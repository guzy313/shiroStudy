package com.my.shiroAuthorization.realm;

import com.my.shiroAuthorization.service.SecurityService;
import com.my.shiroRealmHash.tools.DigestsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Map;

public class ShiroAuthorizationRealm extends AuthorizingRealm{

    public ShiroAuthorizationRealm() {
        //创建密码匹配器对象（用来制定当前realm的密码匹配规则）
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //传入加密方式
        credentialsMatcher.setHashAlgorithmName(DigestsUtil.SHA1);
        //传入加密迭代次数
        credentialsMatcher.setHashIterations(DigestsUtil.HashIterations);
        //将密码匹配器对象 设置为当前realm的密码匹配器(匹配器为当前类接口的一个属性) 此处匹配器将生效
        this.setCredentialsMatcher(credentialsMatcher);
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("======开始授权=====");
        //获取用户凭证信息
        String primaryPrincipal = String.valueOf(principalCollection.getPrimaryPrincipal());
        //从数据库查询用户对应的角色和权限
        SecurityService securityService = new SecurityService();
        List<String> roleByLoginName = securityService.findRoleByLoginName(primaryPrincipal);
        List<String> permissions = securityService.findPermissionByLoginName(primaryPrincipal);

        //构建资源校验对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleByLoginName);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        System.out.println("======授权结束=====");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始获取认证信息");
        //获取当前登录用户
        String principal = String.valueOf(authenticationToken.getPrincipal());

        //通过当前登录用户获取密码和salt(查询数据库)
        SecurityService securityService = new SecurityService();
        Map<String, String> passwordAndSalt = securityService.getPasswordByUserName(principal);
        if(passwordAndSalt.isEmpty()){
            try {
                throw new AccountNotFoundException("不存在该账号");
            } catch (AccountNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("加密后的密码:"+passwordAndSalt.get("password"));
        System.out.println("salt:"+passwordAndSalt.get("salt"));
        //创建登录用户信息类,并存入从数据库获取到的 正确信息 用以比对
        SimpleAuthenticationInfo simpleAuthenticationInfo
                = new SimpleAuthenticationInfo(principal,passwordAndSalt.get("password"),
                ByteSource.Util.bytes(passwordAndSalt.get("salt")),this.getName());
        System.out.println("成功获取认证信息");

        return simpleAuthenticationInfo;
    }
}
