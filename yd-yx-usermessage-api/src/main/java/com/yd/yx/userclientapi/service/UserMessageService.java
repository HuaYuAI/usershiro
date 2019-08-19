package com.yd.yx.userclientapi.service;

import com.yd.yx.userclientapi.dto.base.BaseResultDTO;
import com.yd.yx.userclientapi.dto.user.request.*;

/**
 * Created by huayu on 2019/8/18.
 */
public interface UserMessageService {


    /*
     * 检查用户是否已经注册
     */
    BaseResultDTO<Boolean> checkUsername(CheckUserMessageRequestDTO checkUserMessageRequestDTO);

    /*
     * 注册用户
     */
    BaseResultDTO registeredUser (RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO);

    /*
     * 修改用户信息
     */
    BaseResultDTO updateUserMessage (UpdateUserMessageRequestDTO updateUserMessageRequestDTO);

    /*
     * 核对token
     */
    BaseResultDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO);



    BaseResultDTO userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO);


    BaseResultDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO);
}
