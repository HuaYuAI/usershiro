package com.yd.yx.oauth.service.repository.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;


/**
 * Created by huayu on 2019/8/19.
 */
@Entity
@Data
public class UserMessage implements UserDetails {

    private static final long serialVersionUID = -7466302520048738851L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Integer sex;

    private Integer userStatus;

    private String birthday;

    private String salt;

    private Date registerTime;

    private Date loginTime;

    private String logoutTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
