package com.yd.yx.userservice.service.repository.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserGroupAuthorities {

    private Long groupId;

    private String authority;

}
