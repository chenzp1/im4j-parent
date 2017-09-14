package com.im4j.service.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * 用户
 * Created by chenzp on 2017/9/14 0014.
 */
public class UserRealm extends AuthorizingRealm {

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String s = "11";
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); // 获取用户名
        if(username != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(username, "2", "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
