package com.yd.yx.userclient.controller;

import com.yd.yx.common.dto.BaseResponseDTO;
import com.yd.yx.common.utils.ResultUtil;
import com.yd.yx.common.vo.ResultVO;
import com.yd.yx.userclient.vo.user.RegisterUserRequestVO;
import com.yd.yx.userclientapi.dto.user.request.RegisteredUserMessageRequestDTO;
import com.yd.yx.userclientapi.service.UserMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huayu on 2019/8/18.
 */
@Api("用户信息管理")
@RestController
public class UserRestApiController {

    @Autowired
    private UserMessageService userMessageService;

    @ApiOperation("检测用户名称是否存在")
    @GetMapping("/user/checkusername/{username}")
    public ResultVO registerUser(@PathVariable String username){
        BaseResponseDTO baseResponseDTO =
                userMessageService.checkUsername(username);
        return ResultUtil.success(baseResponseDTO.getData());
    }

    @ApiOperation("注册用户")
    @PostMapping("/user/register")
    public ResultVO registerUser(@RequestBody RegisterUserRequestVO registerUserRequestVO){
        RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO =
                new RegisteredUserMessageRequestDTO();
        BeanUtils.copyProperties(registerUserRequestVO,registeredUserMessageRequestDTO);
        BaseResponseDTO baseResponseDTO = userMessageService.registeredUser(registeredUserMessageRequestDTO);
        return ResultUtil.success(baseResponseDTO.getData());
    }

}
