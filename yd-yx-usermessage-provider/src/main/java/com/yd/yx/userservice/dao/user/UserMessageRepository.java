package com.yd.yx.userservice.dao.user;

import com.yd.yx.userservice.entity.user.UserMessage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @Query(nativeQuery = true, value = "SELECT * FROM trans_mgmt.doc_pv where product_name = ?1 and state_date = ?2 and language = ?3")
 *
 * Created by huayu on 2019/8/19.
 */
public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {

    UserMessage findByUsername(String username);
}
