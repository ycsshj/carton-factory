package com.carton.util;

import com.carton.vo.base.Result;
import org.apache.commons.lang3.StringUtils;

public class ApiHelper {

    public static Result getFailResult() {
        Result resultBO = new Result();
        resultBO.setCode(Result.ERROR);
        resultBO.setMessage(Result.MSG_ERROR_DESC);
        return resultBO;
    }

    public static Result getSuccessResult() {
        Result resultBO = new Result();
        resultBO.setCode(Result.SUCCESS);
        resultBO.setMessage(Result.MSG_SUCCESS_DESC);
        return resultBO;
    }

    public static Result getSuccessResult(Object data) {
        Result resultBO = new Result();
        resultBO.setCode(Result.SUCCESS);
        resultBO.setMessage(Result.MSG_SUCCESS_DESC);
        resultBO.setData(data);
        return resultBO;
    }

    public static Result getFailResult(String msg) {
        if (!StringUtils.isNotBlank(msg)) {
            return getFailResult();
        }
        Result resultBO = new Result();
        resultBO.setCode(Result.ERROR);
        resultBO.setMessage(msg);
        return resultBO;
    }

    public static Result getFailResult(String msg, Object data) {
        if (!StringUtils.isNotBlank(msg)) {
            return getFailResult();
        }
        Result resultBO = new Result();
        resultBO.setCode(Result.ERROR);
        resultBO.setMessage(msg);
        resultBO.setData(data);
        return resultBO;
    }

    public static Result getFailResult(Integer code, String msg) {
        Result resultBO = new Result();
        resultBO.setCode(code);
        resultBO.setMessage(msg);
        return resultBO;
    }
}
