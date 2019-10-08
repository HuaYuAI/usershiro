package com.yd.yx.userservice.controller;

import com.yd.yx.common.log.Anoymous;
import com.yd.yx.common.utils.ResultUtil;
import com.yd.yx.common.vo.ResultVO;
import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.userclientapi.service.UserMessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huayu on 2019/8/26.
 */
@RestController
public class UserProviderController {

    @Autowired
    UserMessageService userMessageService;

    @ApiOperation("检测用户名称是否存在")
    @GetMapping("/user/checkusername/{username}")
    @Anoymous
    public ResultVO registerUser(@PathVariable String username){
        BaseResponseDTO baseResponseDTO =
                userMessageService.checkUsername(username);
        return ResultUtil.success(baseResponseDTO.getData());
    }

/*    @ApiOperation("检测用户名称是否存在")
    @PostMapping("/user/userLogIn")
    @Anoymous
    public ResultVO userLogIn(@RequestBody String username){
        userMessageService.userLogIn()
        return ResultUtil.success();
    }*/



}
