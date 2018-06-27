package com.carton.vo.base;

import java.io.Serializable;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-27 15:53
 ************************************************************/

public class Result implements Serializable {
    public static final Integer SUCCESS = 0;
    public static final String MSG_SUCCESS_DESC = "操作成功！";

    public static final Integer ERROR = -1;
    public static final String MSG_ERROR_DESC = " 抱歉，系统忙！";

    public static final Integer NOTLOGIN = -2;
    public static final String MSG_NOTLOGIN_DESC = "用户未登录！";

    private int code = 0;
    private String message = "";
    private Object data = new Object();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
