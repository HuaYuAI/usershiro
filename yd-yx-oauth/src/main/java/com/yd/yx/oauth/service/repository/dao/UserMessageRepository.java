package com.yd.yx.oauth.service.repository.dao;

import com.yd.yx.oauth.service.repository.entity.UserMessage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * Created by huayu on 2019/8/19.
 */
public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {

    UserMessage findByUsername(String username);
}
