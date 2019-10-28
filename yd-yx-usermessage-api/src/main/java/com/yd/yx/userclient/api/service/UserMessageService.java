package com.yd.yx.userclient.api.service;

import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.userclient.api.dto.user.request.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by huayu on 2019/8/18.
 */
@FeignClient("usermessage-provider")
public interface UserMessageService {


    /*
     * 检查用户是否已经注册
     */
    @GetMapping(value = "/user/checkusername/{username}")
    BaseResponseDTO<Boolean> checkUsername(@PathVariable("username") String userName);

    /*
     * 注册用户
     */
    @PostMapping(value = "/user/registereduser")
    BaseResponseDTO registeredUser (@RequestBody RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO);

    /*
     * 修改用户信息
     */
    @PostMapping(value = "/user/updateUserMessage")
    BaseResponseDTO updateUserMessage (@RequestBody UpdateUserMessageRequestDTO updateUserMessageRequestDTO);

    /*
     * 核对token
     */
    @PostMapping(value = "/user/userContent")
    BaseResponseDTO userContent(@RequestBody ContentUserMessageRequestDTO contentUserMessageRequestDTO);

    @PostMapping(value = "/user/userLogIn")
    BaseResponseDTO userLogIn(@RequestBody LoginUserMessageRequestDTO loginUserMessageRequestDTO);

    @PostMapping(value = "/user/userLogOut")
    BaseResponseDTO userLogOut(@RequestBody LogOutUserMessageRequestDTO logOutUserMessageRequestDTO);
}
