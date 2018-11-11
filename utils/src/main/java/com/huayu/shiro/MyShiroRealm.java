package com.huayu.shiro;

import com.huayu.shiro.pojo.Sysuser;
import com.huayu.shiro.service.SysroleService;
import com.huayu.shiro.service.SysuserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by huayu on 2018/6/29.
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysuserService sysuserService;
    @Autowired
    private SysroleService sysroleService;
    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //获取用户
        Sysuser sysuser = (Sysuser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //获取用户角色
        Set<String> roleSet = new HashSet<String>();
        String [] roleIds = sysuser.getRoleIds().split(",");
        for (int i = 0;i<roleIds.length;i++){
            roleSet.add(sysroleService.selecetByRid(roleIds[i]).getRole());
        }
        info.setRoles(roleSet);

        //获取用户权限
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);

        return info;
    }

    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        //根据用户名查找，没有用户名提醒用户注册
        Sysuser sysuser = null;
        try{
            sysuser = sysuserService.findByUsername(username);
        }catch(Exception e){
            throw new ExpiredCredentialsException();
        }
        if(sysuser != null){
            //判断用户状态
            if(sysuser.getLocked()){
                //判断用户名是否正确，
                return new SimpleAuthenticationInfo(sysuser,password, getName());
/*                if(DigestUtils.md5DigestAsHex((password+sysuser.getSalt()).getBytes()).equals(sysuser.getPassword())){
                    return new SimpleAuthenticationInfo(username,password, getName());
                }else{
                    //密码错误
                    throw new IncorrectCredentialsException();
                }*/
            }else {
                throw new DisabledAccountException();
            }
        }else{
            //没找到帐号,注解开发自定义拦截器。
            throw new UnknownAccountException();
        }

    }
}
