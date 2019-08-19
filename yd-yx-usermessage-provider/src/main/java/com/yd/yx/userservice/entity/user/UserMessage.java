package com.yd.yx.userservice.entity.user;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;


/**
 * Created by huayu on 2019/8/19.
 */
@Entity
@Data
public class UserMessage {

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    private String username;

    private Integer userstatus;

    private String password;

    private String usersort;

    private Date registertime;

    private String logintime;

    private String logouttime;
}
