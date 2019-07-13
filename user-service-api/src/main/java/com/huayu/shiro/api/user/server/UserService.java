package com.huayu.shiro.api.user.server;

import com.huayu.shiro.api.user.User;
import com.huayu.shiro.api.user.dto.UserLoginRequest;
import com.huayu.shiro.api.user.dto.UserLoginResponse;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

/**
 * 用户服务
 * Created by huayu on 2019/6/1.
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param user
     * @return 如果成功返回<code>ture</code>
     * 否则返回<code>false</code>
     */
    boolean save (User user);

    /**
     * 查询所有用户对象
     *
     * @Return 不会返回<code>null</code>
     *
     */
    Collection<User> findAll();

    UserLoginResponse login (UserLoginRequest userLoginRequest);

}
