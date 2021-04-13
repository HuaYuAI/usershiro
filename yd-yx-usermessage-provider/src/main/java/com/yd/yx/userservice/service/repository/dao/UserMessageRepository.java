package com.yd.yx.userservice.service.repository.dao;

import org.springframework.data.repository.CrudRepository;
import com.yd.yx.userservice.service.repository.entity.UserMessage;
/**
 *
 * Created by huayu on 2019/8/19.
 */
public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {

    UserMessage findByUsername(String username);
}
