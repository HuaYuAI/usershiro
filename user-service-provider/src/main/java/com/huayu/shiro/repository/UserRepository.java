package com.huayu.shiro.repository;

import com.huayu.shiro.api.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by huayu on 2019/6/1.
 */
@Component
public class UserRepository {


    private ConcurrentHashMap<Long,User> repository = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);

    public boolean save(User user) {
        Long id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.putIfAbsent(id,user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
