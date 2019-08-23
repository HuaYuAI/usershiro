package com.yd.yx.common.utils;

import com.yd.yx.common.constant.CommonConstant;
import com.yd.yx.common.vo.ResultVO;

/**
 * Created by huayu on 2019/8/20.
 */

public class ResultUtil {
    protected ResultUtil() {}

    public static ResultVO success(Object object) {
        ResultVO result = new ResultVO();
        result.setCode(CommonConstant.STATUS_CODE_SUCCESS);
        result.setMsg(CommonConstant.STATUS_MSG_SUCCESS);
        result.setData(object);
        return result;
    }

    public static ResultVO sucess() {
        return success(null);
    }

    public static ResultVO error() {
        ResultVO result = new ResultVO();
        result.setCode(CommonConstant.STATUS_CODE_FAIL);
        result.setMsg(CommonConstant.STATUS_MSG_FAIL);
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
        result.setMsgCode(msgCode);
        result.setMsg(msg);
        return result;
    }
}
