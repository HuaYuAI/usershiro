package com.yd.yx.userservice.service.repository.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserAuthorities {

    private Long userId;

    private String authority;
}
