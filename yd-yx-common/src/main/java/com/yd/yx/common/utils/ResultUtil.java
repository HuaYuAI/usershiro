package com.yd.yx.common.utils;

import com.yd.yx.common.constant.CommonConstant;
import com.yd.yx.common.constant.ResponseStatusEnum;
import com.yd.yx.common.vo.ResultVO;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
public class ResultUtil {
    protected ResultUtil() {}

    public static ResultVO success(Object object) {
        ResultVO result = new ResultVO();
        result.setCode(ResponseStatusEnum.SUCCESS.getCode());
        result.setMsg(ResponseStatusEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    public static ResultVO sucess() {
        return success(null);
    }

    public static ResultVO error() {
        ResultVO result = new ResultVO();
        result.setCode(ResponseStatusEnum.FAIL.getCode());
        result.setMsg(ResponseStatusEnum.FAIL.getMessage());
        return result;
    }

    public static ResultVO error(String code, String msg) {
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResultVO error(String code, String msgCode, String msg){
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
