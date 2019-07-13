package com.huayu.shiro.api.user;

import lombok.Data;

/**
 * 用户模型API
 * Created by huayu on 2019/6/1.
 */
@Data
public class User {

    private Long id;

    private String username;

    private String passward;

}
