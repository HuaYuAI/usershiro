package com.yd.yx.userservice.dao.user;

import com.yd.yx.userservice.entity.user.UserMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by huayu on 2019/8/19.
 */
public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {
}
