package com.yd.yx.userservice.entity.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


/**
 * Created by huayu on 2019/8/19.
 */
@Entity
@Data
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Integer userstatus;

    private String password;

    private String salt;

    private Date registertime;

    private Date logintime;

    private String logouttime;
}
