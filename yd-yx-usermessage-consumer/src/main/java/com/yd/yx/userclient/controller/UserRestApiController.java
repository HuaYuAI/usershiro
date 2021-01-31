package com.yd.yx.userclient.controller;

import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.common.utils.ResultUtil;
import com.yd.yx.common.vo.ResultVO;
import com.yd.yx.userclient.api.dto.user.request.RegisteredUserMessageRequestDTO;
import com.yd.yx.userclient.api.service.UserMessageService;
import com.yd.yx.userclient.vo.user.RegisterUserRequestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public ResultVO registerUser(@PathVariable String username) {
        BaseResponseDTO baseResponseDTO =
                userMessageService.checkUsername(username);
        return ResultUtil.success(baseResponseDTO.getData());
    }

    @ApiOperation("注册用户")
    @PostMapping("/user/register")
    public ResultVO registerUser(@RequestBody RegisterUserRequestVO registerUserRequestVO) {
        RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO =
                new RegisteredUserMessageRequestDTO();
        BeanUtils.copyProperties(registerUserRequestVO, registeredUserMessageRequestDTO);
        BaseResponseDTO baseResponseDTO = userMessageService.registeredUser(registeredUserMessageRequestDTO);
        return ResultUtil.success(baseResponseDTO.getData());
    }


    public static void main(String[] args) {
        System.out.println(StringUtils.isNumeric("11.0"));
    }
/*    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }*/
    public static boolean isNumeric(String str) {
        //Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");//这个有问题，一位的整数不能通过
        Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");//这个是对的
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}