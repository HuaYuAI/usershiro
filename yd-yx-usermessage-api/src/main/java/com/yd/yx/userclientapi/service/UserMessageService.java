package com.yd.yx.userclientapi.service;

import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.userclientapi.dto.user.request.*;

/**
 * Created by huayu on 2019/8/18.
 */
public interface UserMessageService {


    /*
     * 检查用户是否已经注册
     */
    BaseResponseDTO<Boolean> checkUsername(String userName);

    /*
     * 注册用户
     */
    BaseResponseDTO registeredUser (RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO);

    /*
     * 修改用户信息
     */
    BaseResponseDTO updateUserMessage (UpdateUserMessageRequestDTO updateUserMessageRequestDTO);

    /*
     * 核对token
     */
    BaseResponseDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO);



    BaseResponseDTO userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO);


    BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO);
}
